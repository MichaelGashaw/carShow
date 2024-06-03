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
		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Jane", "Doe");
		Owner owner3 = new Owner("Jack", "Doe");
		Owner owner4 = new Owner("Jane", "Doe");

		Car car1 = new Car("Ford", "Corolla", "Blue", "ABC123", 2019, 30000, owner1);
		Car car2 = new Car("Chevrolet", "3 Series", "White", "XYZ789", 2020, 30000, owner2);
		Car car3 = new Car("Chevrolet", "Camaro", "Blue", "GHI654", 2021, 35000, owner3);
		Car car4 = new Car("Ford", "Corolla", "Black", "LMN456", 2021, 30000, owner4);




		ownerRepository.save(owner1);
		ownerRepository.saveAll(Arrays.asList(owner2,owner3,owner4));
		carRepository.save(car1);
		carRepository.saveAll((Arrays.asList(car2,car3,car4)));


		carRepository.findAll().forEach(car -> System.out.println(car));
	}
}
