package com.funda.schoolapplicationapp.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.funda.schoolapplicationapp.exceptions.LearnerAlreadyAppliedException;
import com.funda.schoolapplicationapp.exceptions.LearnerNotFoundException;

@ControllerAdvice
public class LearnerExceptionController {

	
	@ResponseBody
	@ExceptionHandler(value = LearnerAlreadyAppliedException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<Object>exception(LearnerAlreadyAppliedException  learnerAlreadyExistsExceptio){
		return new ResponseEntity<Object>("You have already applied", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = LearnerNotFoundException.class)
	public ResponseEntity<Object>deleteException(LearnerNotFoundException learnerNotFoundException){
		return new ResponseEntity<Object>("The learner is not found", HttpStatus.NOT_FOUND);
	}
}
