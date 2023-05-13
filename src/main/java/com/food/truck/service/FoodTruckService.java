package com.food.truck.service;

import com.food.truck.dao.FoodTruckRepository;
import com.food.truck.errorHandler.FoodTruckNotFoundException;
import com.food.truck.model.FoodTruckSearch;
import com.food.truck.model.FoodTruck;
import com.food.truck.util.DataLoader;
import com.food.truck.util.Common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.UnaryOperator;

@Service
public class FoodTruckService implements IService {
		
	private Logger logger = LoggerFactory.getLogger(FoodTruckService.class);

    @Autowired
    private FoodTruckRepository repository;

    @Autowired
    private DataLoader dataLoader;

    
    @Override
    public List<FoodTruck> findAll() {
        List<FoodTruck> result = repository.findAll();
        return result;
    }

    
    public FoodTruck addNewFoodTruck(FoodTruck newFoodTruck) throws Exception{
        return repository.save(newFoodTruck);
    }

    public FoodTruck findOneFoodTruckId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new FoodTruckNotFoundException(id));
    }

    
    public List<FoodTruck> findByFoodItemsAndAddressCriteria(FoodTruckSearch foodTruckSearch) throws Exception {
    	
    	if (foodTruckSearch.getAddress() != null 
    			&& !foodTruckSearch.getAddress().isEmpty()
    			&& foodTruckSearch.getFoodItems() != null
    			&& !foodTruckSearch.getFoodItems().isEmpty()
    			) {
    		return repository.findByFoodItemsContainingIgnoreCaseAndAddressContainingIgnoreCase(foodTruckSearch.getFoodItems(), foodTruckSearch.getAddress());
    	} else if (foodTruckSearch.getFoodItems() != null
    			&& !foodTruckSearch.getFoodItems().isEmpty()
    			) {
    		return repository.findByFoodItemsContainingIgnoreCase(foodTruckSearch.getFoodItems());
    	} else if (foodTruckSearch.getAddress() != null 
    			&& !foodTruckSearch.getAddress().isEmpty()
    			) {
    		return repository.findByAddressContainingIgnoreCase(foodTruckSearch.getAddress());
    	}
    	return null;
    }

    public List<FoodTruck> findBySearchCriteria(FoodTruckSearch foodTruckSearch) throws Exception {
    	FoodTruck  searchCriteria = new FoodTruck();
    	searchCriteria.setApplicant(foodTruckSearch.getApplicant());
    	searchCriteria.setFacilityType(Common.getFacilityTypeValid(foodTruckSearch.getFacilityType()));
    	searchCriteria.setAddress(foodTruckSearch.getAddress());
    	searchCriteria.setStatus(foodTruckSearch.getStatus());
    	searchCriteria.setFoodItems(foodTruckSearch.getFoodItems());
        // Goal is to return Union of various search result based on criteria
        List<FoodTruck> result = findAll();
        if (searchCriteria.getApplicant() == null
                && searchCriteria.getFacilityType() == null
        		&& searchCriteria.getFoodItems() == null
                && searchCriteria.getAddress() == null
                && searchCriteria.getStatus() == null)
            return result;

        if (searchCriteria.getApplicant().isEmpty()
                && searchCriteria.getFacilityType() == null
                && searchCriteria.getFoodItems().isEmpty()
                && searchCriteria.getAddress().isEmpty()
                && searchCriteria.getStatus() == null)
            return result;
        
        HashMap<Long, FoodTruck> foodTruckHashMap = new HashMap<>();
        if (searchCriteria.getApplicant() != null && !searchCriteria.getApplicant().isEmpty()) {
        	repository
                    .findByApplicantContainingIgnoreCase(searchCriteria.getApplicant())
                    .forEach(s -> foodTruckHashMap.put(s.getFoodTruckId(), s));

        } else if (searchCriteria.getFacilityType() != null) {
        	result.stream()
    		.filter(a -> a.getFacilityType().equals(searchCriteria.getFacilityType())) 
                    .forEach(s -> foodTruckHashMap.put(s.getFoodTruckId(), s));

        } else if (searchCriteria.getAddress() != null && !searchCriteria.getAddress().isEmpty()) {
        	repository
    				.findByAddressContainingIgnoreCase(searchCriteria.getAddress())
                    .forEach(s -> foodTruckHashMap.put(s.getFoodTruckId(), s));

        } else if (searchCriteria.getFoodItems() != null && !searchCriteria.getFoodItems().isEmpty()) {
        	repository
    				.findByFoodItemsContainingIgnoreCase(searchCriteria.getFoodItems())
                    .forEach(s -> foodTruckHashMap.put(s.getFoodTruckId(), s));

        } else if (searchCriteria.getStatus() != null ) {
        	result.stream()
            		.filter(a -> a.getStatus().equals(searchCriteria.getStatus()))   
                    .forEach(s -> foodTruckHashMap.put(s.getFoodTruckId(), s));
        }
        return new ArrayList<FoodTruck>(foodTruckHashMap.values());
    }

    private List<FoodTruck> priorityBasedSearch(FoodTruck searchCriteria) {
        List<FoodTruck> result = new ArrayList<>();
        if (searchCriteria.getApplicant() != null || !searchCriteria.getApplicant().isEmpty()) {
            result = repository.findByApplicantContainingIgnoreCase(searchCriteria.getApplicant());
        } else if (searchCriteria.getFacilityType() != null) {
            result = repository.findByFacilityTypeEquals(searchCriteria.getFacilityType());
        } else if (searchCriteria.getAddress() != null) {
            result = repository.findByAddressEquals(searchCriteria.getAddress());
        } else if (searchCriteria.getStatus() != null) {
            result = repository.findByStatusEquals(searchCriteria.getStatus());
        }
        return result;
    }

    public FoodTruck saveOrUpdate(FoodTruck newFoodTruck, Long id) throws Exception {
        if (null != id) {
        	FoodTruck foodTruck = repository.getOne(id);
            if (foodTruck != null) {
            	foodTruck.setApplicant(newFoodTruck.getApplicant());
            	foodTruck.setFacilityType(newFoodTruck.getFacilityType());
            	foodTruck.setFoodItems(newFoodTruck.getFoodItems());            	
            	foodTruck.setAddress(newFoodTruck.getAddress());
            	foodTruck.setStatus(newFoodTruck.getStatus());
                return repository.save(foodTruck);
            }
        }
        return repository.save(newFoodTruck);
    }

    public void deleteFoodTruck(Long id) throws Exception {
        repository.deleteById(id);
    }

    public void loadInitialDataFromFile(String fileName) {
        try {
            List<FoodTruck> foodTruck = dataLoader.loadFoodTruckRecords(fileName);
            foodTruck.stream().peek(s -> logger.info("saving" + s)).forEach(s -> repository.save(s));
        } catch (Exception ex) {
            logger.error("Could not load the foot truck record in system: " + ex.getMessage());
        }
    }

    private Date toSqlDate(String rawDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return Date.valueOf(LocalDate.parse(rawDate, formatter));
    }
}
