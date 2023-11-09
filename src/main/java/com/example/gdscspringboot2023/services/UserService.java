package com.example.gdscspringboot2023.services;

import com.example.gdscspringboot2023.entities.User;
import com.example.gdscspringboot2023.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
