package com.food.truck.errorHandler;

public class FoodTruckNotFoundException extends RuntimeException {

    public FoodTruckNotFoundException(Long id) {
        super("Food Truck id not found : " + id);
    }

}
