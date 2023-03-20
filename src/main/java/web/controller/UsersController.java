package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;



@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService us;

    @Autowired
    public UsersController(UserService us) {
        this.us = us;
    }



}
