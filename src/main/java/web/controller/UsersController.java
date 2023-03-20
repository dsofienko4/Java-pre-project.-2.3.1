package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService us;

    @Autowired
    public UsersController(UserService us) {
        this.us = us;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("allUsers", us.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showUserBiId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", us.getUserBiId(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        us.saveUser(user);
        return "redirect:/users/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", us.getUserBiId(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        us.updateUser(user);
        return "redirect:/users/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        us.removeUserBiId(id);
        return "redirect:/users/index";
    }

}
