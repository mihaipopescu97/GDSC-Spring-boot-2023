package com.example.gdscspringboot2023.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "USER", schema = "gdsc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Role> roles;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Project> projects;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
