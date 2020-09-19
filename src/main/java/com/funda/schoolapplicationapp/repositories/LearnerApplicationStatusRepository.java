package com.funda.schoolapplicationapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.funda.schoolapplicationapp.model.LearnerApplicationStatus;
import com.funda.schoolapplicationapp.model.LearnerModel;

@Repository
public interface LearnerApplicationStatusRepository extends JpaRepository<LearnerApplicationStatus, Long> {

	LearnerModel save(LearnerModel learnerModel); 
	
}
