package com.binary.controller;

import com.binary.dto.CarDto;
import com.binary.entity.Car;
import com.binary.exceptions.CarNotFoundException;
import com.binary.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@Profile(value = "dev")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String carMessage() {
        return "Hello, This is from Rest Controller";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) throws CarNotFoundException {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody @Valid CarDto carDto) {
        Car createdCar = carService.createCar(carDto);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody @Valid CarDto carDto) throws CarNotFoundException {
        Car updatedCar = carService.updateCar(id, carDto);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteCar(@PathVariable long id) throws CarNotFoundException {
        carService.deleteCar(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
