package com.example.gdscspringboot2023.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Project", schema = "gdsc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity{

    private String name;

    @ManyToMany
    @JoinTable(name = "project_user", schema = "gdsc", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonBackReference
    private List<User> users;
}
