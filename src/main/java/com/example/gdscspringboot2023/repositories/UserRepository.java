package com.example.gdscspringboot2023.repositories;

import com.example.gdscspringboot2023.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
