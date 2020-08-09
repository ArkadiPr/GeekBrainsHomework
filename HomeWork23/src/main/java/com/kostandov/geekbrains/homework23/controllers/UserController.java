package com.kostandov.geekbrains.homework23.controllers;

import com.kostandov.geekbrains.homework23.entitys.User;
import com.kostandov.geekbrains.homework23.services.UserService;
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
    public String getUsers(Model model, @RequestParam(required = false)Long idUser) {
        model.addAttribute("users", userService.requiredUsers(idUser));
        return "all_users";
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/allusers";
    }

    @GetMapping("/users/remove/{id}")
    public String removeUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/allusers";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-edit-page";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/allusers";
    }



}
