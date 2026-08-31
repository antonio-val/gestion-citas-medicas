package com.mycompany.patient.dto;

public class PatientPartiallyUpdateRequestDTO {
	private String firstName;
	private String lastName;
	private String nationalIdNumber;

	public PatientPartiallyUpdateRequestDTO() {
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
