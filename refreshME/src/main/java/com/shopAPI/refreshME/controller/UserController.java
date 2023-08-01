package com.shopAPI.refreshME.controller;

import com.shopAPI.refreshME.model.User;
import com.shopAPI.refreshME.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // RestController is like a magic keyword that tells the Spring Framework that this class is meant to handle requests and return responses
public class UserController {
    UserService userService;

    @Autowired
    //whenever we use the userService variable, Spring will provide the necessary "UserService" object for us to work with.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Optional<User> getUserByName(@RequestParam(value = "id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public void saveUserByName(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        userService.saveUser(username, password);
    }
}