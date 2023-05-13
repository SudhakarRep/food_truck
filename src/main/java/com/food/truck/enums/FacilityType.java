package com.food.truck.enums;

public enum FacilityType {
	
	    TRUCK("Truck"),
	    PUSH_CART("Push Cart");
	  
	    private String displayName;
	
		FacilityType(String displayName) {
	        this.displayName = displayName;
	    }

	    public String displayName() { return displayName; }

	    @Override 
	    public String toString() { return displayName; }
	    
}
