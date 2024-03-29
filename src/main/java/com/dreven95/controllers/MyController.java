package com.dreven95.controllers;

import com.dreven95.models.User;
import com.dreven95.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "index";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "index";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "index";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);

        return "index";
    }
}
