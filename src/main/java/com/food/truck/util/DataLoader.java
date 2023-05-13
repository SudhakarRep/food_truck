package com.food.truck.util;

import com.food.truck.enums.FacilityType;
import com.food.truck.enums.Status;
import com.food.truck.model.FoodTruck;

import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {
    public List<FoodTruck> loadFoodTruckRecords(String fileName) throws IOException {
        List<FoodTruck> result = new ArrayList<>();
        File file = ResourceUtils.getFile("classpath:" + fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            // Read first line
            String line = br.readLine();
            // Make sure file has correct headers
            if (line == null) throw new IllegalArgumentException("File is empty");

            if (!line.equals("locationid,Applicant,FacilityType,cnn,LocationDescription,Address,blocklot,block,lot,permit,Status,FoodItems,X,Y,Latitude,Longitude,Schedule,dayshours,NOISent,Approved,Received,PriorPermit,ExpirationDate,Location,Fire Prevention Districts,Police Districts,Supervisor Districts,Zip Codes,Neighborhoods (old)"))
                throw new IllegalArgumentException("File has wrong columns: " + line);

            // Run through following lines
            while ((line = br.readLine()) != null) {
                // Break line into entries using comma
                String[] items = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                try {
                	
                    if (items.length > 100) throw new ArrayIndexOutOfBoundsException();
                    FoodTruck foodTruck = new FoodTruck();
                    
                    if (items.length > 0 && !StringUtils.isEmpty(items[0]))  {
                    	
                    	foodTruck.setLocationId(Common.getInteger(items[0]));
                    	foodTruck.setApplicant(items[1]);
	                   
	                    
                    	foodTruck.setFacilityType(Common.getFacilityTypeValid(items[2]));	                    
                    	foodTruck.setCnn(Integer.valueOf(items[3]));
                    	foodTruck.setLocation(items[4]);
                    	foodTruck.setAddress(items[5]);
                    	foodTruck.setBlocklot(items[6]);
                    	foodTruck.setBlock(items[7]);
                    	foodTruck.setLot(items[8]);
                    	foodTruck.setPermit(items[9]);
	                    	                   
                    	foodTruck.setStatus(Status.valueOf(items[10]));
                    	foodTruck.setFoodItems(items[11]);
                    	foodTruck.setX(Common.getDouble(items[12]));
                    	foodTruck.setY(Common.getDouble(items[13]));
                    	foodTruck.setLatitude(Common.getDouble(items[14]));
                    	foodTruck.setLongitude(Common.getDouble(items[15]));
                    	foodTruck.setSchedule(items[16]);
                    	foodTruck.setDayshours(items[17]);
                    	foodTruck.setNoiSent(DateUtils.formatDateTime(items[18]));
                    	foodTruck.setApproval(DateUtils.formatDateTime(items[19]));
                    	foodTruck.setReceived(Common.getInteger(items[20]));
                    	foodTruck.setPriorPermit(Common.getByte(items[21]));
                    	foodTruck.setExpirationDate(DateUtils.formatDateTime(items[22]));
                    	foodTruck.setLocation(items[23]);
                    	foodTruck.setFirePreventionDistricts(Common.getByte(items[24]));
                    	foodTruck.setPoliceDistricts(Common.getByte(items[25]));
                    	foodTruck.setSupervisorDistricts(Common.getByte(items[26]));
                    	foodTruck.setZipCodes(Common.getInteger(items[27]));
                    	foodTruck.setNeighborhoods_old(Common.getByte(items[28]));
	                    
	                    result.add(foodTruck);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Record Found: " + line);
                    System.out.println(e);
                }
            }
            return result;
        } finally {
            br.close();
        }
    }

}