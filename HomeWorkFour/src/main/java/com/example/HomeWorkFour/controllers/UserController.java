package com.example.HomeWorkFour.controllers;

import com.example.HomeWorkFour.models.User;
import com.example.HomeWorkFour.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User u, Model model) {
        userService.addUser(u);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}