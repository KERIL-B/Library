package kirill.bessonov.test.model.Repositories;

import kirill.bessonov.test.Exeptions.IsnAlreadyExistsExeption;

import kirill.bessonov.test.model.Book;
import kirill.bessonov.test.model.Mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        final String query = "SELECT BOOKS.ID, BOOKS.ISN, BOOKS.NAME, BOOKS.AUTHOR, USERS.LOGIN FROM BOOKS\n" +
                "LEFT JOIN USERS ON BOOKS.USER_ID=USERS.ID\n" +
                "ORDER BY BOOKS.AUTHOR";
        return jdbcTemplate.query(query, new BookMapper());
    }

    public boolean addBook(int isn, String name, String author) {
        try {
            if (name.length() > 0 && name != null && author.length() > 0 && author != null)
                if (exists(isn)) {
                    throw new IsnAlreadyExistsExeption();
                } else {
                    final String query = "INSERT INTO BOOKS (isn,name,author,user_id) VALUES (?,?,?,?)";
                    jdbcTemplate.update(query, isn, name, author, 0);
                    return true;
                }
            else return false;
        } catch (IsnAlreadyExistsExeption e) {
            System.out.println("Book with that isn already exists");
            return false;
        }
    }

    public void deleteBookByIsn(int isn) {
        final String query = "DELETE FROM BOOKS WHERE isn=?";
        jdbcTemplate.update(query, isn);
    }

    public boolean bindUserForBook(long book_id, long user_id) {
        final String query = "UPDATE BOOKS SET user_id=? WHERE id=?";
        return jdbcTemplate.update(query, user_id, book_id) == 1;
    }

    public boolean freeBook(long book_id) {
        return bindUserForBook(book_id, 0);
    }

    private boolean exists(int isn) {
        final String query = "SELECT COUNT(*) FROM BOOKS WHERE isn=?";
        return jdbcTemplate.queryForObject(query, Integer.class, isn) == 1;
    }
}
