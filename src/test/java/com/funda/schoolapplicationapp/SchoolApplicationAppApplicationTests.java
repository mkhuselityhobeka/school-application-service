package com.funda.schoolapplicationapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.funda.schoolapplicationapp.controller.LearnerController;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.repositories.LearnerModelRepository;

@SpringBootTest
class SchoolApplicationAppApplicationTests {

	@Autowired
	LearnerController LearnerController;
	
	@Autowired
	LearnerModelRepository learnerModelRepository;
	
	@Test
	void contextLoads() {
		assertThat(LearnerController).isNotNull();
	}

	@Test
	public void testFindLeranerByID() {
		LearnerModel learnerModel = learnerModelRepository.findByLearnerID("8803165736982");
		System.out.println("id num is " + learnerModel.getId());
		assertThat(learnerModel.getId()).isEqualTo("8803165736982");
	}
  
}
