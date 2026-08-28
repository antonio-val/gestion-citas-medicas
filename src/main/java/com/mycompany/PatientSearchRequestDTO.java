package com.mycompany;

public class PatientSearchRequestDTO {
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
