package com.funda.schoolapplicationapp.dto;

import org.springframework.stereotype.Component;


import lombok.Data;

@Data
@Component
public class LearnerApplicationStatusDTO {

	
	private String gradeApplyingFor;
	private String currentGrade;
	private byte[] reportCard;
	private String applicationStatus ;
	private LearnerApplicationStatusDTO learnerModel;
}
