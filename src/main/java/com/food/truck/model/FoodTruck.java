package com.food.truck.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.food.truck.enums.FacilityType;
import com.food.truck.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foodtrunk")
public class FoodTruck implements Serializable {
    @Column(name = "foodtruckid")
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long foodTruckId;

    @Column(name = "locationid")
    private Integer locationId = null;
    
    @Column(name = "applicant")
    private String applicant=null;
    
    @Column(name = "facility_type")
    private FacilityType facilityType=null;
    
    @Column(name = "cnn")
    private Integer cnn = null;
    
    @Column(name = "location_description")
    private String locationDescription=null;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address cannot be blank")
    private String address=null;
       
    @Column(name = "blocklot")
    private String blocklot=null;
   
    @Column(name = "block")
    private String block=null;
    
    @Column(name = "lot")
    private String lot=null;
    
    @Column(name = "permit")
    private String permit=null;
    
    @Column(name = "status")
    private Status status=null;
    
    @Column(name = "food_items", nullable = false)
    @NotBlank(message = "Food items cannot be blank")
    private String foodItems=null;
    
    @Column(name = "x")
    private Double x=null;
    
    @Column(name = "y")
    private Double y=null;
    
    @Column(name = "latitude")
    private Double latitude=null;
    
    @Column(name = "longitude")
    private Double longitude=null;
    
    @Column(name = "schedule")
    private String schedule=null;
    
    @Column(name = "dayshours")
    private String dayshours=null;
    
    @Column(name = "noi_sent", columnDefinition = "TIMESTAMP DEFAULT NULL")
    private Date noiSent=null;
    
    @Column(name = "approval", columnDefinition = "TIMESTAMP DEFAULT NULL")
    private Date approval=null;
    
    @Column(name = "received")
    private Integer received = null;

    @Column(name = "prior_permit")
    private Byte priorPermit = null;

    @Column(name = "expiration_date", columnDefinition = "TIMESTAMP DEFAULT NULL")
    private Date expirationDate;
    
    @Column(name = "location")
    private String location=null;
    
    @Column(name = "fire_prevention_districts")
    private Byte firePreventionDistricts = null;
    
    @Column(name = "police_districts")
    private Byte policeDistricts = null;
    
    @Column(name = "supervisor_districts")
    private Byte supervisorDistricts = null;
    
    @Column(name = "zipcodes")
    private Integer zipCodes = null;
    
    @Column(name = "neighborhoods_old")
    private Byte neighborhoods_old = null;

    
    
 
}
