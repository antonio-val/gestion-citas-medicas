package com.mycompany.patient.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PatientDTO {
	@NotNull(message = "{patient.error.publicIdMandatory}")
	private UUID publicId;
	@NotBlank(message = "{patient.error.firstNameMandatory}")
	private String firstName;
	@NotBlank(message = "{patient.error.lastNameMandatory}")
	private String lastName;
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String nationalIdNumber;

	public PatientDTO() {
		// Empty
	}
	
	public UUID getPublicId() {
		return publicId;
	}

	public void setPublicId(UUID publicId) {
		this.publicId = publicId;
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
