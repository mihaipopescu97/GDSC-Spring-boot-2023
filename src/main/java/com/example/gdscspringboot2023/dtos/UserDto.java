package com.example.gdscspringboot2023.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private AddressDto address;

    private List<RoleDto> roles;

    private List<ProjectDto> projects;
}
