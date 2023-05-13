package com.food.truck;

import com.food.truck.service.FoodTruckService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class FoodTruckApplication {
    @Autowired
    FoodTruckService foodTruckService;
    final String fileName = "Mobile_Food_Facility_Permit.csv";

    static public void main(String[] args) {
        SpringApplication.run(FoodTruckApplication.class, args);
        
    }
    
    
    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
        	foodTruckService.loadInitialDataFromFile(fileName);
        };
    }
    
}
