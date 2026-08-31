package com.mycompany.patient.dto;

import jakarta.validation.constraints.NotBlank;

public class PatientCreateRequestDTO {
	@NotBlank(message = "{patient.error.firstNameMandatory}")
	private String firstName;
	@NotBlank(message = "{patient.error.lastNameMandatory}")
	private String lastName;
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String nationalIdNumber;

	public PatientCreateRequestDTO() {
		// Empty
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
