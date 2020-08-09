package com.kostandov.geekbrains.homework22.controllers;

import com.kostandov.geekbrains.homework22.entitys.User;
import com.kostandov.geekbrains.homework22.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public String getUsers(Model model,@RequestParam(required = false)Long idUser) {
        model.addAttribute("users", userService.requiredUsers(idUser));
        return "all_users";
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/allusers";
    }


}
