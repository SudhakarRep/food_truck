package com.food.truck.taglibs;

import org.apache.commons.text.StringEscapeUtils;

public class Utilities {
    public static String escapeJS(String value) {
        //return StringEscapeUtils.escapeEcmaScript(value);
    	return StringEscapeUtils.escapeHtml4(value);
    	
    }
}