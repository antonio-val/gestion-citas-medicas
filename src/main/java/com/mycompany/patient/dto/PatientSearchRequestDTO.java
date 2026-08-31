package com.mycompany.patient.dto;

import jakarta.validation.constraints.NotBlank;

public class PatientSearchRequestDTO {
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String nationalIdNumber;

	public PatientSearchRequestDTO(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	
}
