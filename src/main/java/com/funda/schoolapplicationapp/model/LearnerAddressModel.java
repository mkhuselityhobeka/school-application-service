package com.funda.schoolapplicationapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "Address")
@EqualsAndHashCode
@Component
public class LearnerAddressModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String houseNumber;
	private String streetName; 
	private String town; 
	private String city; 
	private String postalCode;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "learner_id")
	private LearnerModel learnerModel;

	@Override
	public String toString() {
		return "LearnerAddressModel [id=" + id + ", houseNumber=" + houseNumber + ", streetName=" + streetName
				+ ", town=" + town + ", city=" + city + ", postalCode=" + postalCode + "]";
	} 
		

}
