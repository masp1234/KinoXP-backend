package com.example.kinoxpbackend.controllers;

import com.example.kinoxpbackend.models.User;
import com.example.kinoxpbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add/user")
    public void addUser(@RequestParam("name") String name,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("type") String type){
        User user = new User(name, username, password, type);
        userService.saveUser(user);
    }
    @GetMapping("get/user/{username}")
    public User findUserByUsername(@PathVariable("username") String username){
        User user = userService.getUserByUsername(username);
        /*
        if(user == null){
            throw new RuntimeException("det virker ikke");
        }
        */

        //mangler at handle hvis en bruger der ikke findes bliver kaldt
        return user;
    }
}
