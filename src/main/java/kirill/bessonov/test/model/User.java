package kirill.bessonov.test.model;

import java.util.List;

public class User {

    private long id;
    private String login;
    private String password;

    public User() {
    }

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }


    @Override
    public String toString() {
        return "[id: "+id+"; login: "+login+"]";
    }

    //Generated getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
