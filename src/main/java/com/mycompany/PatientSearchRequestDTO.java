package com.mycompany;

import jakarta.validation.constraints.NotBlank;

public class PatientSearchRequestDTO {
	@NotBlank(message = "El DNI es obligatorio")
	private String nationalIdNumber;

	public PatientSearchRequestDTO(String nationalIdNumber) {
		super();
		this.nationalIdNumber = nationalIdNumber;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	
}
