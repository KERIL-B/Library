package kirill.bessonov.test.model;

public class Book {

    private long id;
    private int isn;
    private String name;
    private String author;
    private String user_login;

    public Book() {
    }

    public Book(long id, int isn, String name, String author, String user_login) {
        this.id = id;
        this.isn = isn;
        this.name = name;
        this.author = author;
        this.user_login=user_login;
    }

    @Override
    public String toString() {
        return "[ id: " + id + "; isn: " + isn + "; name: " + name + "; author: " + author + "; user_login: " + user_login + "]";
    }


    //generated getters & setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIsn() {
        return isn;
    }

    public void setIsn(int isn) {
        this.isn = isn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }
}
