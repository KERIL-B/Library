package kirill.bessonov.test.Exeptions;

public class UserAlreadyExistsExeption extends Exception {

    public UserAlreadyExistsExeption() {
    }

    public UserAlreadyExistsExeption(String message) {
        super(message);
    }
}
