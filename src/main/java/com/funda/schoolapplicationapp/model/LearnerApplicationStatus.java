package com.funda.schoolapplicationapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ApplicationStatus")
@Entity
@Component
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class LearnerApplicationStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String gradeApplyingFor;
	private String currentGrade;
	private byte[] reportCard;
	private String applicationStatus ;
	
	@OneToOne(
			   fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "learner_id")
	private LearnerModel learnerModel;

	@Override
	public String toString() {
		return "LearnerApplicationStatus [id=" + id + ", gradeApplyingFor=" + gradeApplyingFor + ", currentGrade="
				+ currentGrade + ", reportCard=" + reportCard + ", applicationStatus=" + applicationStatus
				+ ", learnerModel=" + learnerModel + "]";
	}

    	
	
}
