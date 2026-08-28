package com.mycompany;

import jakarta.validation.constraints.NotBlank;

public class PatientPartiallyUpdateDTO {
	private String firstName;
	private String lastName;
	@NotBlank(message = "El DNI es obligatorio")
	private String nationalIdNumber;

	public PatientPartiallyUpdateDTO() {
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
