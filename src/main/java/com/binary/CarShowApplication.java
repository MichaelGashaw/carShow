package com.binary;

import com.binary.entity.Car;
import com.binary.entity.Owner;
import com.binary.repository.CarRepository;
import com.binary.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CarShowApplication implements CommandLineRunner {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner = new Owner("John", "Doe");

		Car car1 = new Car("Ford", "Corolla", "Blue", "ABC123", 2019, 30000, owner);
		Car car2 = new Car("Chevrolet", "3 Series", "White", "XYZ789", 2020, 30000, owner);
		Car car3 = new Car("Chevrolet", "Camaro", "Blue", "GHI654", 2021, 35000, owner);
		Car car4 = new Car("Ford", "Corolla", "Black", "LMN456", 2021, 30000, owner);
		Car car5 = new Car("Toyota", "Camaro", "Gray", "DEF321", 2018, 25000, owner);

		ownerRepository.save(owner);
		carRepository.save(car1);
		System.out.println("car1 is saved");
		carRepository.saveAll(Arrays.asList(car2, car3, car4, car5));
		System.out.println("rest of the cars is saved");
	}
}
