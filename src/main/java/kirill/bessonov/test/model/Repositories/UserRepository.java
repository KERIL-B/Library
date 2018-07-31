package kirill.bessonov.test.model.Repositories;

import kirill.bessonov.test.Exeptions.UserAlreadyExistsExeption;
import kirill.bessonov.test.model.Mappers.UserMapper;
import kirill.bessonov.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        final String query = "SELECT * FROM USERS";
        return jdbcTemplate.query(query, new UserMapper());
    }

    public boolean addUser(String login, String password) {
       try {
            if (exists(login)) {
                throw new UserAlreadyExistsExeption();
            } else {
                final String query = "INSERT INTO USERS (login,password) VALUES (?,?)";
                jdbcTemplate.update(query, login, password);
                return true;
            }
        } catch (UserAlreadyExistsExeption e) {
            System.out.println("User already exists");
            return false;
        }
    }

    public void deleteUserById(long id) {
        final String query = "DELETE FROM USERS WHERE id=?";
        jdbcTemplate.update(query, id);
    }

    public boolean checkPassword(String login, String password)
    {
        final String query="SELECT password FROM USERS WHERE login=?";
        return jdbcTemplate.queryForObject(query, String.class,login).equals(password);
    }

    private boolean exists(String login) {
        final String query = "SELECT COUNT(*) FROM USERS WHERE login=?";
        return jdbcTemplate.queryForObject(query, Integer.class,login) == 1;
    }
}
