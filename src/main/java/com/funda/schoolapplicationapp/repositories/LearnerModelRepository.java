package com.funda.schoolapplicationapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.funda.schoolapplicationapp.model.LearnerModel;

@Repository
public interface LearnerModelRepository extends JpaRepository<LearnerModel, Long>{
            LearnerModel findByLearnerID(String learnerIDNumber);
}
