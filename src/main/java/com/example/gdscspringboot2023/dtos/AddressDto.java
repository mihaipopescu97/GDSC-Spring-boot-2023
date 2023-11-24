package com.example.gdscspringboot2023.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String streetName;

    private Integer streetNumber;
}
