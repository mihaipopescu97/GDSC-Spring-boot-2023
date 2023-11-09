package com.example.gdscspringboot2023.controllers;

import com.example.gdscspringboot2023.entities.User;
import com.example.gdscspringboot2023.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        final User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody final User user) {
        final User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        userService.deleteUser(id);
    }
}
