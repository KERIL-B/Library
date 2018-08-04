package kirill.bessonov.test.controllers;

import kirill.bessonov.test.model.Book;
import kirill.bessonov.test.model.Repositories.BookRepository;
import kirill.bessonov.test.model.User;
import kirill.bessonov.test.model.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        System.out.println("USERS\n" + (List<User>) userRepository.getAllUsers());
        System.out.println("BOOKS\n" + (List<Book>) bookRepository.getAllBooks());

        scanner.next();
    }

    private void addSomeData() {
        bookRepository.addBook(100, "The Art Of Java", "H. Schildt");
        bookRepository.addBook(101, "Harry Potter", "J. Rowling");
        bookRepository.addBook(102, "Hamlet", "W.  Shakespeare");
        bookRepository.addBook(103, "War and Peace", "L. Tolstoy");
        bookRepository.addBook(104, "Don Quixote", "Miguel de Cervantes");

        userRepository.addUser("Keril", "qwerty");
        userRepository.addUser("xXX_killer_XXx", "2003");
        userRepository.addUser("James_Bond", "007");
        userRepository.addUser("Satan", "666");
        userRepository.addUser("Jesus", "777");

        bindSomeBooks();
    }

    private void bindSomeBooks() {
        bookRepository.bindUserForBook(36, 1);
        bookRepository.bindUserForBook(34, 4);
        bookRepository.bindUserForBook(33, 2);
        bookRepository.bindUserForBook(35, 3);
    }
}
