package com.shopAPI.refreshME.services;

import com.shopAPI.refreshME.models.User;
import com.shopAPI.refreshME.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void saveUser(String username, String password, String confirmPassword){
        userRepository.save(new User(username, password, confirmPassword));
    }

    public Optional<User> validateLogin(String username, String password) {
        Optional<User> userOptional = userRepository.findByUserName(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return userOptional; // Login successful
            }
        }
        return Optional.empty(); // Login failed
    }

    public boolean doesUserExist(String username) {
        return userRepository.findByUserName(username).isPresent();
    }


}
