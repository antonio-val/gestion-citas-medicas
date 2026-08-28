package com.mycompany;

public class PatientPartiallyUpdateDTO {
	private String firstName;
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
	
	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
}
