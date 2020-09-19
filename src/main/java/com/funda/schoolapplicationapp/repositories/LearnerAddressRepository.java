package com.funda.schoolapplicationapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funda.schoolapplicationapp.model.LearnerAddressModel;

@Repository
public interface LearnerAddressRepository extends JpaRepository<LearnerAddressModel, Long>{

}
