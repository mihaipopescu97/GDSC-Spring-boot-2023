package com.example.gdscspringboot2023.services;

import com.example.gdscspringboot2023.dtos.UserDto;
import com.example.gdscspringboot2023.entities.Address;
import com.example.gdscspringboot2023.entities.User;
import com.example.gdscspringboot2023.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public User getUser(final Long id) {
        final List<User> userList = userRepository.findAllByName("test");
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(final User user) {
        if (user.getAddress() != null) {
            final Address address = user.getAddress();
            address.setUser(user);
        }

        if (user.getRoles() != null) {
            user.getRoles().forEach(role -> role.setUser(user));
        }

        if (user.getProjects() != null && !user.getProjects().isEmpty()) {
            user.getProjects().forEach(project -> project.setUsers(List.of(user)));
        }
        return userRepository.save(user);
    }

    public User updateUser(final UserDto userDto) {
        final Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            modelMapper.map(userDto, user);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
