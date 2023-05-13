package com.food.truck.model;


import com.food.truck.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodTruckSearch {
	private String applicant;
	private String facilityType;
	private String foodItems;
	private String address;
	private Status status;
}
