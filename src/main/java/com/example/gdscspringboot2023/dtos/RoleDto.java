package com.example.gdscspringboot2023.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {

    private Long id;

    private String name;

    private Integer priority;
}
