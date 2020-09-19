package com.funda.schoolapplicationapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Learner")
@Entity
@Component
public class LearnerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "name cannot be empty")
	private String name;
	@NotBlank(message = "last name cannot be empty")
	private String lastName;
	@NotBlank(message = "age cannot be empty")
	private String age;
	@NotBlank(message = "dob cannot be empty")
	private String dob;
	@NotBlank(message = "contact number cannot be empty")
	private String contactNumber;
	@NotBlank(message = "id number cannot be empty")
	private String learnerID;
	
	@OneToMany(
			mappedBy = "learnerModel",
			cascade = CascadeType.ALL)
	private List<LearnerAddressModel> learnerAddressModel = new ArrayList<>();
	
	
	@OneToOne(mappedBy = "learnerModel",
			cascade = CascadeType.ALL)
    private LearnerApplicationStatus applicationStatus;

	@Override
	public String toString() {
		return "LearnerModel [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", dob=" + dob
				+ ", contactNumber=" + contactNumber + ", learnerID=" + learnerID + "]";
	}
	
}
