package com.binary.service;

import com.binary.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();
    public void createCar(Car car);
    public void updateCar(Car car);
    public void deleteCar(Car car);


}
