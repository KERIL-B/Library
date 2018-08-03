package kirill.bessonov.test.controllers;


import kirill.bessonov.test.model.Repositories.BookRepository;
import kirill.bessonov.test.model.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WebController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String booksController(Model model) {
        model.addAttribute("books", bookRepository.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersController(Model model) {
        model.addAttribute("users", userRepository.getAllUsers());
        return "users";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String getProfile(Model model, @ModelAttribute("login") String login) {
        userRepository.deleteUserByLogin(login);
        return "redirect:/users";
    }
}
