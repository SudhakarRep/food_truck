package com.food.truck.util;


import java.text.ParseException;

import org.springframework.util.StringUtils;

import java.sql.Date;

public class DateUtils {
	
    public static Date formatDateTime(String dateOrNull)  throws ParseException{
    	
    	if (StringUtils.isEmpty(dateOrNull))
    	    return null;
    	
    	String[] splitDateStr = dateOrNull.split(" ");
    	String[] splitDate = splitDateStr[0].split("/");    	
    	return Date.valueOf(new StringBuilder()
    			.append(splitDate[2])
    			.append("-")
    			.append(splitDate[0])
    			.append("-")
    			.append(splitDate[1]).toString());
    	
    }
    
    
}
