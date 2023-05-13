package com.food.truck.util;

import org.springframework.util.StringUtils;

import com.food.truck.enums.FacilityType;

public class Common {
	
	public static String getFacilityTypeKey(String data) {
		
		if (!StringUtils.isEmpty(data))
		{
		    return null;
		    
		}
		return null;
	}
	
	public static FacilityType getFacilityTypeValid(String data) {
		if (StringUtils.isEmpty(data)) {
	    	return null;
	    } else if (data.toLowerCase().contains("push")) {
	    	return FacilityType.PUSH_CART;
	    } else if (data.toLowerCase().contains("truck")) {
	    	return FacilityType.TRUCK;
	    } else if (data.contains(FacilityType.TRUCK.displayName())) {
	    	return FacilityType.TRUCK;
	    } else {
	    	return FacilityType.PUSH_CART;
	    }
	}
	
	public static Double getDouble(String data) {
		if (!StringUtils.isEmpty(data)) {
			return Double.valueOf(data);
		} else {
			return null;
		}
	}
	
	public static Integer getInteger(String data) {
		if (!StringUtils.isEmpty(data)) {
			return Integer.valueOf(data);
		} else {
			return null;
		}
	}
		
	public static Byte getByte(String data) {
		if (!StringUtils.isEmpty(data)) {
			return Byte.valueOf(data);
		} else {
			return null;
		}
	}
}
