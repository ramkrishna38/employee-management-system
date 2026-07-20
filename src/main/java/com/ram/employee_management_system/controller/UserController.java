package com.ram.employee_management_system.controller;

import com.ram.employee_management_system.model.User;
import com.ram.employee_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){

        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

        return userService.login(user);

    }

}