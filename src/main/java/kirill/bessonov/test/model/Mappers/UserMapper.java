package kirill.bessonov.test.model.Mappers;

import kirill.bessonov.test.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Nullable
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        long id = resultSet.getLong("id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");

        return new User(id, login, password);
    }
}
