package com.example.demo.repo;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data SQL repository for the Car entity.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}
