package com.binary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private String color;
    private String registerNumber;
    private int year;
    private String make;
    @Column(name = "car_price")
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    @JsonIgnore
    private Owner owner;



    public Car(String brand, String model, String color, String registerNumber, int year, double price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

}
