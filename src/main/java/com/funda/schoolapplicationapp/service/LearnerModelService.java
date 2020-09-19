package com.funda.schoolapplicationapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.funda.schoolapplicationapp.exceptions.LearnerAlreadyAppliedException;
import com.funda.schoolapplicationapp.exceptions.LearnerNotFoundException;
import com.funda.schoolapplicationapp.model.LearnerAddressModel;
import com.funda.schoolapplicationapp.model.LearnerApplicationStatus;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.repositories.LearnerModelRepository;



@Service
public class LearnerModelService{
	
	@Autowired
	LearnerModelRepository learnerModelRepository;
	@Autowired
	LearnerAddressModel addressModel;
	@Autowired
	LearnerModel learnerModel;
	@Autowired
	LearnerApplicationStatus learnerApplicationStatus;
	
	
	/* add learner*/
	public LearnerModel saveLearner(LearnerModel learnerModel) throws LearnerAlreadyAppliedException{
		
		 List<LearnerApplicationStatus> learnerApplicationStatusList = new ArrayList<LearnerApplicationStatus>();
		 LearnerApplicationStatus leanerStatus = learnerModel.getApplicationStatus();
		 learnerApplicationStatusList.add(leanerStatus);
		
		if(findByIDNumber(learnerModel.getLearnerID())) {
			
			throw new LearnerAlreadyAppliedException();	
			
		}else{	
			
			learnerModel.getLearnerAddressModel().forEach(addressModel-> addressModel.setLearnerModel(learnerModel));
			learnerApplicationStatusList.forEach(learnerApplicationStatus -> learnerApplicationStatus.setLearnerModel(learnerModel));

			return learnerModelRepository.save(learnerModel);
		}
		
	}
	
	/* delete learner*/
	public String deleteLearner(Long id) throws LearnerNotFoundException{
		
		if(learnerModelRepository.findById(id).isPresent()) {
			
			learnerModelRepository.deleteById(id);
			return "successfully delete learner";
			
		}else {
			
			throw new LearnerNotFoundException();
		}
	}

	
	/* update learner*/
	public LearnerModel updateLearner(LearnerModel learnerModel, Long id) throws LearnerNotFoundException {

        Optional<LearnerModel>optional = learnerModelRepository.findById(id);
        
        if(optional.isPresent()) {
        	
        	learnerModel.setId(id);
        	learnerModel.getLearnerAddressModel().forEach(addressModel-> addressModel.setLearnerModel(learnerModel));  	     	
        	return learnerModelRepository.save(learnerModel);
       
        }else {
			
        	throw new LearnerNotFoundException();
		}
	
	}
	
	/*return all learners*/
	public List<LearnerModel> findaAllLearners() {		
		return learnerModelRepository.findAll();	
	}

	/* filter by  learner id number*/
	public boolean findByIDNumber(String idNumber) {	
		LearnerModel learnerModel = learnerModelRepository.findByLearnerID(idNumber);	
		
		if(learnerModel != null) {
		
			return true;
		}else {
			return false;

		}
		
	}
}
