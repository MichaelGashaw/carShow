package com.binary.repository;

import com.binary.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    //count() returns the number of entity
    //findAll() returns all item of given type
    //findByID return one item by id
    //delete(T Entity) Delete entity
    //delete(T Entity) saves an entity
    //saveAll() saves all the the entities
}
