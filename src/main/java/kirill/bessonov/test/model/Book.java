package kirill.bessonov.test.model;

public class Book {

    private long id;
    private int isn;
    private String name;
    private String author;
    private long user_id;

    public Book() {
    }

    public Book(long id, int isn, String name, String author, long user_id) {
        this.id = id;
        this.isn = isn;
        this.name = name;
        this.author = author;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "[ id: "+id+"; isn: "+isn+"; name: "+name+"; author: "+author+"; user_id: "+user_id+"]";
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
