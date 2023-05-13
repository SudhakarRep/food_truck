package com.food.truck.controller;

import com.food.truck.enums.FacilityType;
import com.food.truck.enums.Status;
import com.food.truck.model.FoodTruckSearch;
import com.food.truck.model.FoodTruck;
import com.food.truck.service.FoodTruckService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import javax.validation.Valid;

@RestController
public class FoodTruckController {
	
	private static final Logger logger = LoggerFactory.getLogger(FoodTruckController.class);

    @Autowired
    private FoodTruckService foodTruckService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
    	try {
	        ModelAndView model = new ModelAndView("index");
	        List<FoodTruck> allFoodTrunks = foodTruckService.findAll();
	        model.addObject("list", allFoodTrunks);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());  
	        return model;
    	} catch (Exception ex) {
    		logger.error("Home Exception: ", ex.getMessage());
    		return null;
    	}
    }
    
    @RequestMapping(value = "/foodtruck", method = RequestMethod.GET)
    public ModelAndView foodTruckLoad() {
    	try {
	        ModelAndView model = new ModelAndView("foodtruck");
	        List<FoodTruck> allFoodTrucks = foodTruckService.findAll();
	        model.addObject("list", allFoodTrucks);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());        
	        return model;
    	} catch (Exception ex) {
    		logger.error("foodTruckLoad Exception: ", ex.getMessage());
    		return null;
    	}
    }

    @PostMapping("/foodtruck/search")
    ModelAndView findAll(FoodTruckSearch searchCriteria) {
    	try { 
	    	ModelAndView model = new ModelAndView("foodtruck");
	        List<FoodTruck> result = foodTruckService.findBySearchCriteria(searchCriteria);
	        model.addObject("list", result);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());  
	        return model;
    	} catch (Exception ex) {
    		logger.error("findAll Exception: ", ex.getMessage());
    		return null;
    	}
    }
    
    @PostMapping("/home/search")
    ModelAndView findAllFT(FoodTruckSearch searchCriteria) {
    	try {
	    	ModelAndView model = new ModelAndView("index");
	        List<FoodTruck> result = foodTruckService.findBySearchCriteria(searchCriteria);
	        model.addObject("list", result);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());
	        return model;
    	} catch (Exception ex) {
    		logger.error("findAllFT Exception: ", ex.getMessage());
    		return null;
    	}
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/foodtruck/add", method = RequestMethod.POST)
    ModelAndView addNewFoodTruck(@ModelAttribute("addFoodTruck") FoodTruck newFoodTruck) {
    	try {
	    	foodTruckService.saveOrUpdate(newFoodTruck, null);    	
	        return foodTruckLoad();
    	} catch (Exception ex) {
    		logger.error("addNewFoodTruck Exception: ", ex.getMessage());
    		return null;
    	}
    }

    @RequestMapping(value = "/foodtruck/edit/{id}", method = RequestMethod.POST)
    ModelAndView updateFoodTruckRecord(@ModelAttribute("editFoodTruck") FoodTruck newFoodTruck, @PathVariable("id") Long id) {
    	try {
	        foodTruckService.saveOrUpdate(newFoodTruck, id);
	        return foodTruckLoad();
    	} catch (Exception ex) {
    		logger.error("updateFoodTruckRecord Exception: ", ex.getMessage());
    		return null;
    	}
    }

    @RequestMapping("/foodtruck/delete")
    ModelAndView deleteFoodTruck(@RequestParam String foodTruckId) {
    	try {
	        foodTruckService.deleteFoodTruck(Long.valueOf(foodTruckId));
	        return foodTruckLoad();
    	} catch (Exception ex) {
    		logger.error("deleteFoodTruck Exception: ", ex.getMessage());
    		return null;
    	}
    }

    @RequestMapping(value = "/foodtruck/edit", method = RequestMethod.GET)
    ModelAndView editFoodTruck(@RequestParam String foodTruckId) {
    	try { 
	        ModelAndView model = new ModelAndView("edit");
	        FoodTruck foodTruck = foodTruckService.findOneFoodTruckId(Long.valueOf(foodTruckId));
	        model.addObject("foodTruck", foodTruck);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());  
	        return model;
    	} catch (Exception ex) {
    		logger.error("deleteFoodTruck Exception: ", ex.getMessage());
    		return null;
    	}
    }
   
    @RequestMapping(value = "/foodtruck/add", method = RequestMethod.GET)
    public ModelAndView addFoodTruck() {
    	try { 
	        ModelAndView model = new ModelAndView("addFoodTruck");
	        List<FoodTruck> allFoodTrucks = foodTruckService.findAll();
	        model.addObject("list", allFoodTrucks);
	        model.addObject("facilityType", FacilityType.values());
	        model.addObject("status", Status.values());  
	        return model;
    	} catch (Exception ex) {
    		logger.error("deleteFoodTruck Exception: ", ex.getMessage());
    		return null;
    	}
    }   
    

    @GetMapping(path="api/v1/foodtruck", produces = "application/json")
    public List<FoodTruck> getFoodTruck() 
    {
    	List<FoodTruck> allFoodTrucks = foodTruckService.findAll();
        return allFoodTrucks;
    }
    

    @PostMapping(path="api/v1/foodtruck/search", consumes = "application/json", produces = "application/json")
    public List<FoodTruck> searchFoodTruck(@RequestBody @Valid FoodTruckSearch searchCriteria) {
    	try {
	    	List<FoodTruck> result = foodTruckService.findByFoodItemsAndAddressCriteria(searchCriteria);
	        return result;
    	} catch (Exception ex) {
    		logger.error("searchFoodTrunk Exception: ", ex.getMessage());
    		return null;
    	}
    }

}
