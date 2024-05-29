package com.binary.service;

import com.binary.entity.Car;
import com.binary.entity.Owner;
import com.binary.repository.CarRepository;
import com.binary.repository.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @InjectMocks
    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    @DisplayName("Get all cars success")
    public void testGetAllCars() {
        List<Car> expectedCars = new ArrayList<>();
        Car car = new Car();
        car.setId(1L);
        car.setBrand("BMW");
        car.setModel("X5");
        expectedCars.add(car);


        Mockito.when(carRepository.findAll()).thenReturn(expectedCars);

        List<Car> actualCars = carService.getAllCars();

        Assertions.assertEquals(expectedCars.size(), actualCars.size());
        Assertions.assertEquals(expectedCars.get(0).getBrand(), actualCars.get(0).getBrand());

    }

    @Test
    @DisplayName("Create car success")
    public void testCreateCar() {
        Owner owner = new Owner();
        owner.setOwnerId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        Car car = new Car();
        car.setId(1L);
        car.setBrand("BMW");
        car.setModel("X5");
        car.setOwner(owner);

        Mockito.when(ownerRepository.save(owner)).thenReturn(owner);
        Mockito.when(carRepository.save(car)).thenReturn(car);

        Car createdCar = carService.createCar(car);

        Assertions.assertNotNull(createdCar);
        Assertions.assertEquals(car.getBrand(), createdCar.getBrand());
        Assertions.assertEquals(car.getOwner().getFirstName(), createdCar.getOwner().getFirstName());
    }

    @Test
    @DisplayName("Update car success")
    public void testUpdateCar() {
        Car existingCar = new Car();
        existingCar.setId(1L);
        existingCar.setBrand("BMW");
        existingCar.setModel("X5");

        Car updatedCar = new Car();
        updatedCar.setBrand("Audi");
        updatedCar.setModel("Q7");

        Mockito.when(carRepository.findById(1L)).thenReturn(Optional.of(existingCar));
        Mockito.when(carRepository.save(existingCar)).thenReturn(existingCar);

        Car result = carService.updateCar(1L, updatedCar);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Audi", result.getBrand());
        Assertions.assertEquals("Q7", result.getModel());
    }

    @Test
    @DisplayName("Delete car success")
    public void testDeleteCar() {
        Car car = new Car();
        car.setId(1L);
        car.setBrand("BMW");

        Mockito.when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        Mockito.doNothing().when(carRepository).deleteById(1L);

        long deletedCarId = carService.deleteCar(1L);

        Assertions.assertEquals(1L, deletedCarId);
    }

    @Test
    @DisplayName("Get car by ID success")
    public void testGetCarById() {
        Car car = new Car();
        car.setId(1L);
        car.setBrand("BMW");

        Mockito.when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Car foundCar = carService.getCarById(1L);

        Assertions.assertNotNull(foundCar);
        Assertions.assertEquals(car.getBrand(), foundCar.getBrand());
    }
}

