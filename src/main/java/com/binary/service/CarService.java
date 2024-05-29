package com.binary.service;

import com.binary.dto.CarDto;
import com.binary.entity.Car;
import com.binary.exceptions.CarNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getAllCars();

    Car getCarById(long id) throws CarNotFoundException;

    Car createCar(CarDto carDto);

    Car updateCar(long id, CarDto carDto) throws CarNotFoundException;

    void deleteCar(long id) throws CarNotFoundException;
}
