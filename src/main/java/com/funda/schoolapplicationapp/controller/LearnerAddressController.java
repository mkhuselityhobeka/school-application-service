package com.funda.schoolapplicationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funda.schoolapplicationapp.model.LearnerAddressModel;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.service.LearnerAddressService;

@RestController
@RequestMapping("/address")
public class LearnerAddressController {

	@Autowired
	LearnerAddressService learnerAddressService;
	
	@PutMapping("update/{id}")
	public LearnerAddressModel updateLearnerAddress(@RequestBody LearnerModel learnerModel, @PathVariable Long id) {
		return learnerAddressService.updateLearnerAddress(learnerModel, id);
	}
	
	@GetMapping("get/{id}")
	public LearnerAddressModel getLearnerAddress(@PathVariable Long id) {
		return learnerAddressService.findLearnerAddressById(id);
	}
}
