package com.funda.schoolapplicationapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.service.LearnerModelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/learner")
@Api(value = "Learner System", description = "Operations pertaining to Learner in Learner System")
public class LearnerController {

	@Autowired
	LearnerModelService learnerModelService;
	
	@PostMapping("save/application")
	@ApiOperation(value = "save learner to db", response = LearnerModel.class)
	public ResponseEntity<LearnerModel> saveLearnerToDB(@RequestBody LearnerModel learnerModel){    
		return new ResponseEntity<LearnerModel>(learnerModelService.saveLearner(learnerModel), HttpStatus.CREATED);
	}
		
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteLearnerFromDB(@PathVariable Long id){	
		return new ResponseEntity<String>(learnerModelService.deleteLearner(id), HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<LearnerModel> updateLupdateLearnerDataearnerData(@RequestBody LearnerModel learnerModel, @PathVariable Long id) {
		return new ResponseEntity<LearnerModel>(learnerModelService.updateLearner(learnerModel, id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("get/all/learners")
	public ResponseEntity<List<LearnerModel>> getAll(){
		return new ResponseEntity<List<LearnerModel>>(learnerModelService.findaAllLearners(), HttpStatus.ACCEPTED);
	}
}
