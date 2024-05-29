package com.binary.service;

import com.binary.dto.CarDto;
import com.binary.entity.Car;
import com.binary.exceptions.CarNotFoundException;
import com.binary.repository.CarRepository;
import com.binary.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Car> getAllCars() {
        List<Car> listOfCars = (List<Car>) carRepository.findAll();
        if (listOfCars.isEmpty()) {
            throw new CarNotFoundException("No cars found in the system.");
        }
        return listOfCars;
    }

    @Override
    public Car getCarById(long id) throws CarNotFoundException {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
    }

    @Override
    public Car createCar(CarDto carDto) {
        if (carDto == null) {
            throw new IllegalArgumentException("CarDto cannot be null");
        }

        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        car.setRegisterNumber(carDto.getRegisterNumber());
        car.setYear(carDto.getYear());
        car.setPrice(carDto.getPrice());
        car.setOwner(carDto.getOwner());

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(long id, CarDto carDto) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));

        if (carDto.getBrand() != null) {
            car.setBrand(carDto.getBrand());
        }
        if (carDto.getModel() != null) {
            car.setModel(carDto.getModel());
        }
        if (carDto.getColor() != null) {
            car.setColor(carDto.getColor());
        }
        if (carDto.getRegisterNumber() != null) {
            car.setRegisterNumber(carDto.getRegisterNumber());
        }
        if (carDto.getYear() != null) {
            car.setYear(carDto.getYear());
        }
        if (carDto.getPrice() > 0) {
            car.setPrice(carDto.getPrice());
        }
        if (carDto.getOwner() != null) {
            car.setOwner(carDto.getOwner());
        }

        return carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) throws CarNotFoundException {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
        carRepository.delete(car);
    }
}
