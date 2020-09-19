package com.funda.schoolapplicationapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.funda.schoolapplicationapp.exceptions.LearnerNotFoundException;
import com.funda.schoolapplicationapp.model.LearnerAddressModel;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.repositories.LearnerAddressRepository;

@Service
public class LearnerAddressService {

	@Autowired
	LearnerAddressRepository addressRepository;
	@Autowired
	LearnerAddressModel addressModel;
	
	public LearnerAddressModel updateLearnerAddress(LearnerModel learnerModel, Long id) throws LearnerNotFoundException{	
	
        Optional<LearnerAddressModel> learnerAddressModelOptional = addressRepository.findById(id);  
		
		if(learnerAddressModelOptional.isPresent()) {
			LearnerAddressModel addressModel = learnerAddressModelOptional.get();
			return addressRepository.save(addressModel);
	    }else {
			throw new LearnerNotFoundException();
		}
		
	}
	
	public LearnerAddressModel findLearnerAddressById(Long id){
		Optional<LearnerAddressModel> learnerAddressModelOptional = addressRepository.findById(id);
		
		if(learnerAddressModelOptional.isPresent()) {
			LearnerAddressModel addressModel = learnerAddressModelOptional.get();
			return addressModel;
		}else {
			return null;
		}
		
	}
}
