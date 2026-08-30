package com.mycompany.patient.dto;

import jakarta.validation.constraints.NotBlank;

public class PatientPartiallyUpdateRequestDTO {
	private String firstName;
	private String lastName;
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String nationalIdNumber;

	public PatientPartiallyUpdateRequestDTO() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
}
