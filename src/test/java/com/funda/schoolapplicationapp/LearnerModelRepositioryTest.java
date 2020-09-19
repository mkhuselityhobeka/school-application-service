package com.funda.schoolapplicationapp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.repositories.LearnerModelRepository;

@RunWith(SpringRunner.class)
public class LearnerModelRepositioryTest {
	
	@Autowired
	LearnerModelRepository learnerModelRepository;
    
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testFindLeranerByID() {
		System.out.println("learnerModelRepository " + learnerModelRepository);
		LearnerModel learnerModel = learnerModelRepository.findByLearnerID("8803165736982");
		assertThat(learnerModel.getId()).isEqualTo("8803165736982");
	}
}
