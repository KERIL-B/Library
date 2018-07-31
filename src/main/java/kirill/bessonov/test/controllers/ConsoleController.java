package kirill.bessonov.test.controllers;

import kirill.bessonov.test.model.Book;
import kirill.bessonov.test.model.Repositories.BookRepository;
import kirill.bessonov.test.model.User;
import kirill.bessonov.test.model.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        System.out.println("Console is running");
        /*userRepository.addUser("keril","keril");
        userRepository.addUser("keril","keril2");
        userRepository.deleteUserById(200);*/
       // bookRepository.addBook(100,"The Art Of Java", "H. Schildt");
        // bookRepository.addBook(101,"The Art Of Java 2", "H. Schildt");
        System.out.println("USERS\n"+(List<User>) userRepository.getAllUsers());
        System.out.println("BOOKS\n"+(List<Book>) bookRepository.getAllBooks());
       // System.out.println(bookRepository.bindUserForBook(2,34));
        bookRepository.deleteBookById(3);
        bookRepository.freeBook(2);
        System.out.println("BOOKS\n"+(List<Book>) bookRepository.getAllBooks());
        //System.out.println(userRepository.checkPassword("keril","keriL"));

        scanner.next();
    }
}
