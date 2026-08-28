package com.mycompany;

import jakarta.validation.constraints.NotBlank;

public class PatientDTO {
	@NotBlank(message = "El nombre es obligatorio")
	private String firstName;
	@NotBlank(message = "El DNI es obligatorio")
	private String nationalIdNumber;

	public PatientDTO() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
}
