package kirill.bessonov.test.model.Repositories;

import kirill.bessonov.test.Exeptions.UserAlreadyExistsExeption;
import kirill.bessonov.test.model.Book;
import kirill.bessonov.test.model.Mappers.BookMapper;
import kirill.bessonov.test.model.Mappers.UserMapper;
import kirill.bessonov.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        final String query = "SELECT * FROM USERS";
        return jdbcTemplate.query(query, new UserMapper());
    }

    public boolean addUser(String login, String password) {
        try {
            if (login != null && password != null && login.length() > 0 && password.length() > 0)
                if (exists(login)) {
                    throw new UserAlreadyExistsExeption();
                } else {
                    final String query = "INSERT INTO USERS (login,password) VALUES (?,?)";
                    jdbcTemplate.update(query, login, password);
                    return true;
                }
            else return false;
        } catch (UserAlreadyExistsExeption e) {
            System.out.println("User already exists");
            return false;
        }
    }

    public void deleteUserByLogin(String login) {
        final String query1 = "SELECT BOOKS.ID, BOOKS.ISN, BOOKS.NAME, BOOKS.AUTHOR, USERS.LOGIN FROM BOOKS \n" +
                "LEFT JOIN USERS ON BOOKS.USER_ID=USERS.ID\n" +
                "WHERE USERS.LOGIN=?\n" +
                "ORDER BY BOOKS.NAME;";
        List<Book> books = jdbcTemplate.query(query1, new BookMapper(), login);

        for (Book book : books
                ) {
            bookRepository.freeBook(book.getId());
        }

        final String query2 = "DELETE FROM USERS WHERE login=?";
        jdbcTemplate.update(query2, login);
    }

    public String getPassword(String login) {
        final String query = "SELECT password FROM USERS WHERE login=?";
        return jdbcTemplate.queryForObject(query, String.class, login);
    }

    private boolean exists(String login) {
        final String query = "SELECT COUNT(*) FROM USERS WHERE login=?";
        return jdbcTemplate.queryForObject(query, Integer.class, login) == 1;
    }
}
