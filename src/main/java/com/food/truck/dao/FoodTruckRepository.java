package com.food.truck.dao;

import com.food.truck.enums.FacilityType;
import com.food.truck.enums.Status;
import com.food.truck.model.FoodTruck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {
    List<FoodTruck> findByApplicantContainingIgnoreCase(String applicant);

    List<FoodTruck> findByFoodItemsContainingIgnoreCase(String foodItems);

    List<FoodTruck> findByAddressContainingIgnoreCase(String address);

    List<FoodTruck> findByFacilityTypeEquals(FacilityType facilityType);

    List<FoodTruck> findByAddressEquals(String address);

    List<FoodTruck> findByStatusEquals(Status status);
    
    List<FoodTruck> findByFoodItemsEquals(String status);
    
    List<FoodTruck> findByFoodItemsContainingIgnoreCaseAndAddressContainingIgnoreCase(String foodItems, String address);
    
        
}
