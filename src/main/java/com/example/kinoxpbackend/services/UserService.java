package com.example.kinoxpbackend.services;

import com.example.kinoxpbackend.models.User;
import com.example.kinoxpbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
