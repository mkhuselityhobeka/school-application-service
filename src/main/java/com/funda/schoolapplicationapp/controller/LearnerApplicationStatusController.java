package com.funda.schoolapplicationapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.funda.schoolapplicationapp.model.LearnerApplicationStatus;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.service.LearnerApplicationStatusService;

@RestController
@RequestMapping("/learner")
public class LearnerApplicationStatusController {

	@Autowired
	LearnerApplicationStatusService applicationStatusService;
	
	@GetMapping("all/status")
	public ResponseEntity<List<LearnerApplicationStatus>>returnAllLearnerStatus() {
		return new ResponseEntity<List<LearnerApplicationStatus>>(applicationStatusService.getAllLearnerApplicationStatus(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("status/{id}")
	public ResponseEntity<LearnerApplicationStatus> getLearnerStatus(@PathVariable Long id) {
		LearnerApplicationStatus learnerModelApplicationStatus =  applicationStatusService.getLearnerFromApplicationStatusById(id);
		
		return new ResponseEntity<LearnerApplicationStatus>(learnerModelApplicationStatus, HttpStatus.OK);
	}
	
	@PutMapping("update/status/{id}")
	public ResponseEntity<LearnerApplicationStatus> updateStatus(@RequestBody LearnerModel LearnerModel,  @PathVariable Long id) {
		LearnerApplicationStatus learnerModelApplicationStatus =  applicationStatusService.approveOrDenyApplication(LearnerModel, id);	
		return new ResponseEntity<LearnerApplicationStatus>(learnerModelApplicationStatus, HttpStatus.OK);
	}
	
}
