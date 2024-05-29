//package com.binary.controllers;
//
//import com.binary.controller.CarController;
//import com.binary.dto.CarDto;
//import com.binary.entity.Car;
//import com.binary.service.CarServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.ACCEPTED;
//
//
//@ExtendWith(MockitoExtension.class)
//public class CarControllerTest {
//    @InjectMocks
//    private CarController carController;
//    @Mock
//    private CarServiceImpl carServiceImpl;
//
//    @Test
//    @DisplayName("car controller get all success")
//    public void carController_getAllCars_success() {
//
//        List<Car> expectedCars = new ArrayList<Car>();
//        Car car = new Car();
//        car.setId(1L);
//        car.setPrice(2500);
//        car.setModel("BMW");
//        expectedCars.add(car);
//
//        Mockito.when(carServiceImpl.getAllCars()).thenReturn(expectedCars);
//
//        ResponseEntity<List<Car>> result = carController.getAllCars();
//
//        Assertions.assertEquals(1, result.getBody().size());
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//
//
//    }
//
//    @Test
//    @DisplayName("car controller get by ID success case")
//    public void carController_getCarById_success() {
//        Car car = new Car();
//        car.setId(2L);
//        long expectedId = 2;
//        Mockito.when(carServiceImpl.getCarById(Mockito.anyLong())).thenReturn(car);
//
//        ResponseEntity<Car> result = carController.getCarById(expectedId);
//
//        Assertions.assertEquals(expectedId, result.getBody().getId());
//
//        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
//
//    }
//
//    @Test
//    @DisplayName("car controller get by ID success case")
//    public void carController_createCar_success() {
//        CarDto carBeforeCreated = new CarDto();
//        carBeforeCreated.setId(2L);
//
//        Car carCreated = new Car();
//        carCreated.setId(3L);
//        carBeforeCreated.setModel(carBeforeCreated.getModel());
//
//        Mockito.when(carServiceImpl.createCar(carBeforeCreated)).thenReturn(carCreated);
//
//        ResponseEntity<Car> result = carController.createCar(carBeforeCreated);
//
//        Assertions.assertEquals(carBeforeCreated.getModel(), result.getBody().getModel());
//        Assertions.assertNotNull(result.getBody().getId());
//        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
//
//    }
//
//    @Test
//    @DisplayName("car controller update car success test case")
//    public void carController_updateCar_success() {
//        Car carBeforeUpdated = new Car();
//        carBeforeUpdated.setId(45);
//        carBeforeUpdated.setYear(2020);
//        carBeforeUpdated.setColor("Red");
//
//        long carIdThatNeedsToBeUpdated = 45;
//
//        Car carUpdated = new Car();
//        carUpdated.setId(2L);
//        carUpdated.setYear(2020);
//        carUpdated.setColor("Blue");
//
//        Mockito.when(carServiceImpl.updateCar(Mockito.eq(carIdThatNeedsToBeUpdated), Mockito.any(Car.class))).thenReturn(carUpdated);
//
//        ResponseEntity<Car> result = carController.updateCar(carIdThatNeedsToBeUpdated, carBeforeUpdated);
//
//        Assertions.assertEquals(carUpdated.getYear(), result.getBody().getYear());
//        Assertions.assertEquals("Blue", result.getBody().getColor());
//        Assertions.assertEquals(ACCEPTED, result.getStatusCode());
//
//
//    }
//
//    @Test
//    @DisplayName("car controller delete car success test case")
//    public void carController_deleteCar_success() {
//        long carIdThatNeedsToBeDeleted = 45;
//        Mockito.when(carServiceImpl.deleteCar(carIdThatNeedsToBeDeleted)).thenReturn(carIdThatNeedsToBeDeleted);
//
//        ResponseEntity<Long> result = carController.deleteCar(carIdThatNeedsToBeDeleted);
//
//        Assertions.assertEquals(carIdThatNeedsToBeDeleted, result.getBody());
//        Assertions.assertEquals(ACCEPTED, result.getStatusCode());
//
//    }
//}
