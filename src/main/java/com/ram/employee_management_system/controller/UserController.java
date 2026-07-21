package com.ram.employee_management_system.controller;

import com.ram.employee_management_system.model.User;
import com.ram.employee_management_system.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register User
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);

    }

    // Login User
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return userService.login(user);

    }

}