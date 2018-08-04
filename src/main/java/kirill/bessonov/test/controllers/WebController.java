package kirill.bessonov.test.controllers;


import kirill.bessonov.test.model.Repositories.BookRepository;
import kirill.bessonov.test.model.Repositories.UserRepository;
import kirill.bessonov.test.webForms.AddBookForm;
import kirill.bessonov.test.webForms.AddUserForm;
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
        model.addAttribute("addBookForm", new AddBookForm());
        return "books";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersController(Model model) {
        model.addAttribute("users", userRepository.getAllUsers());
        model.addAttribute("addUserForm", new AddUserForm());
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUserController(@ModelAttribute("addUserForm") AddUserForm form)
    {
        String login=form.getLogin();
        String password =form.getPassword();
        userRepository.addUser(login,password);
        return "redirect:/users";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addUserController(@ModelAttribute("addBookForm") AddBookForm form)
    {
        int isn=form.getIsn();
        String name=form.getName();
        String author =form.getAuthor();
        bookRepository.addBook(isn,name,author);
        return "redirect:/books";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String deleteUser(Model model, @ModelAttribute("login") String login) {
        userRepository.deleteUserByLogin(login);
        return "redirect:/users";
    }

    @RequestMapping(value = {"/deleteBook"}, method = RequestMethod.GET)
    public String deleteBook(Model model, @ModelAttribute("isn") int isn) {
        bookRepository.deleteBookByIsn(isn);
        return "redirect:/books";
    }
}
