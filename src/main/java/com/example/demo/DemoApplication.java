package com.example.demo;

import com.example.demo.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repo.*;

import java.util.List;


//@EnableSwagger2
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Autowired
    private CarRepository carRepository;

     @GetMapping("/all")
    public List<Car> f(){
         return carRepository.findAll();

        }


}
