package com.shopAPI.refreshME.controllers;

import com.shopAPI.refreshME.models.User;
import com.shopAPI.refreshME.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/user/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/signup")
    public void signup(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "confirmPassword") String confirmPassword,
            HttpServletResponse response) throws IOException {
        // Check if the passwords match
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("/signup.html?error=PasswordsDoNotMatch");
            return;
        }

        if (userService.doesUserExist(username)) {
            response.sendRedirect("/signup.html?error=UsernameAlreadyExists");
            return;
        }

        // Save the user if passwords match
        userService.saveUser(username, password, confirmPassword);
        System.out.println("New user was created");
        response.sendRedirect("/login.html?success=true");
    }

    @PostMapping("/login")
    public void login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        System.out.println("Received login request for username: " + username);

        Optional<User> user = userService.validateLogin(username, password);
        if ("ciobanww".equals(username) && "matei2003".equals(password)){
            System.out.println("Admin user.");
            response.sendRedirect("adminPanel.html?admin");
        }
        else if (user.isPresent()) {
            System.out.println("Login successful for username: " + username);
            // If login is successful, redirect to the welcome page
            response.sendRedirect("/welcome.html?username=" + username);
        } else {
            System.out.println("Login failed for username: " + username);
            // If login fails, redirect back to the login page with an error message
            response.sendRedirect("/login.html?error=InvalidCredentials");
        }
    }
}