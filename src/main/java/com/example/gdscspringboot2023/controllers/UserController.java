package com.example.gdscspringboot2023.controllers;

import com.example.gdscspringboot2023.dtos.UserDto;
import com.example.gdscspringboot2023.entities.User;
import com.example.gdscspringboot2023.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        final User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody final UserDto userDto) {
        log.info("UserController -> post() called");
        final User user = modelMapper.map(userDto, User.class);
        final User createUser = userService.createUser(user);
        final UserDto newUserDto = modelMapper.map(createUser, UserDto.class);
        log.info("UserController -> post() finished");
        return ResponseEntity.ok(newUserDto);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody final UserDto userDto) {
        log.info("UserController -> put() called");
        final User updatedUser = userService.updateUser(userDto);
        final UserDto updatedUserDto = modelMapper.map(updatedUser, UserDto.class);
        log.info("UserController -> put() finished");
        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        userService.deleteUser(id);
    }
}
