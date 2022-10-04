package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.User;
import com.example.kinoxpbackend.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add/user")
    public void addUser(@RequestParam("name") String name,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("type") String type){
        User user = new User(name, username, password, type);
        System.out.println(user);
        userService.saveUser(user);
    }
}
