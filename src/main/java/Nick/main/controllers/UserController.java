package Nick.main.controllers;

import Nick.main.service.UserService;
import Nick.main.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//получение все юзеров
    @GetMapping()
    public String showAllUsers(Model model) {
        if (userService.getUserList().isEmpty()) {
            userService.saveUser(new User("Nick", "Dunichev", "+79104066964"));
            userService.saveUser(new User("Bob", "Taylor", "+74958679506"));
            userService.saveUser(new User("Tom", "Harly", "+74958679506"));
            userService.saveUser(new User("Nick", "Bistmark", "+7495823984"));
            userService.saveUser(new User("Ivan", "Durack", "+74956738509"));
        }
        model.addAttribute("user", userService.getUserList());
        return "all";
    }
//получение юзера по id
    @GetMapping(value = "/{id}")
    public String getUserId(@PathVariable("id") int index, Model model) {
        model.addAttribute("user", userService.getUserById(index));
        return "user";
    }
//создание нового юзера
    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
