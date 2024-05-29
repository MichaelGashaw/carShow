package com.binary.dto;

import com.binary.entity.Owner;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    @NotNull(message = "Brand should not be null")
    private String brand;

    @NotNull(message = "Model should not be null")
    private String model;

    @NotNull(message = "Color should not be null")
    private String color;

    @NotNull(message = "Register Number should not be null")
    private String registerNumber;

    @Min(value = 1990, message = "Year should be at least 1990")
    private Integer year;
    private double price;
    private String make;
    private Owner owner;
}
