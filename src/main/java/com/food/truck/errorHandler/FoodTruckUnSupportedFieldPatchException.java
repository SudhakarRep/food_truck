package com.food.truck.errorHandler;

import java.util.Set;

public class FoodTruckUnSupportedFieldPatchException extends RuntimeException {

    public FoodTruckUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }


}
