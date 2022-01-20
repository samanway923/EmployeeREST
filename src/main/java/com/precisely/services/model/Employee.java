package com.precisely.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Employee {

	@Id        
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String doj;
	private String deptName;
	private String projectName;
	private String location;
	
	public Employee(String firstName, String lastName, String email, String doj, String deptName, String projectName,
			String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.doj = doj;
		this.deptName = deptName;
		this.projectName = projectName;
		this.location = location;
	}

}
