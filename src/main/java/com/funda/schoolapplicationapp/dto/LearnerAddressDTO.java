package com.funda.schoolapplicationapp.dto;

import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class LearnerAddressDTO {

	private String houseNumber;
	private String streetName; 
	private String town; 
	private String city; 
	private String postalCode; 
	private LearnerDTO learnerModel;
}
