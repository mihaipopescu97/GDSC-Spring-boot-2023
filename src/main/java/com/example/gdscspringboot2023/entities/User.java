package com.example.gdscspringboot2023.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity @Table(name = "USER", schema = "gdsc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String name;
}
