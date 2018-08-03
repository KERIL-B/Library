package kirill.bessonov.test.model.Mappers;

import kirill.bessonov.test.model.Book;
import kirill.bessonov.test.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Nullable
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        long id = resultSet.getLong("id");
        int isn = resultSet.getInt("isn");
        String name = resultSet.getString("name");
        String author = resultSet.getString("author");
        String user_login = resultSet.getString("login");

        return new Book(id, isn, name, author, user_login);
    }
}
