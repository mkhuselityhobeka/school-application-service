package com.funda.schoolapplicationapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.funda.schoolapplicationapp.model.LearnerApplicationStatus;
import com.funda.schoolapplicationapp.model.LearnerModel;
import com.funda.schoolapplicationapp.repositories.LearnerApplicationStatusRepository;
import com.funda.schoolapplicationapp.repositories.LearnerModelRepository;


@Service
public class LearnerApplicationStatusService {
    
	@Autowired
	LearnerApplicationStatusRepository applicationStatusRepository;
	@Autowired
	LearnerModelRepository learnerModelRepository;
	@Autowired
	LearnerApplicationStatus applicationStatus;	
	@Autowired
	LearnerModel learnerModel;
	
	/* get learner status by status id*/
    public LearnerApplicationStatus getLearnerFromApplicationStatusById(long id) {
    	
    	Optional<LearnerApplicationStatus> learnerAppliactionStatusOptional = applicationStatusRepository.findById(id);
    	LearnerApplicationStatus learnerAppliactionStatus = learnerAppliactionStatusOptional.get();
    	if(learnerAppliactionStatusOptional.isPresent()) {
    		return learnerAppliactionStatus;
    	
	    }else {
	    	return null;
	    }
    }
    
    /* get all learner status */
	public List<LearnerApplicationStatus>getAllLearnerApplicationStatus(){
		return applicationStatusRepository.findAll();
	}
	
	
	/* approve or deny learner application */
	public LearnerApplicationStatus approveOrDenyApplication(LearnerModel learnerModel, Long id) {
		

      	  List<LearnerApplicationStatus> learnerApplicationStatusList = new ArrayList<LearnerApplicationStatus>();
		  LearnerApplicationStatus  applicationStatus = learnerModel.getApplicationStatus();
		  applicationStatus.setId(id);
		  learnerApplicationStatusList.add(applicationStatus);
		
		 if(applicationStatus != null){
			learnerModel.setId(id);
			learnerModel.getLearnerAddressModel().forEach(addressModel-> addressModel.setLearnerModel(learnerModel));
			learnerApplicationStatusList.forEach(learnerApplicationStatus -> learnerApplicationStatus.setLearnerModel(learnerModel));
			return applicationStatusRepository.save(applicationStatus);
		
		}
		return applicationStatus;	
	}
	
}
