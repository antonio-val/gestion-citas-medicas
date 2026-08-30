package com.mycompany.appointment.dto;

import jakarta.validation.constraints.NotBlank;

public class AppointmentSearchRequestDTO {
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String patientNationalIdNumber;

	public AppointmentSearchRequestDTO() {
		super();
	}

	public String getPatientNationalIdNumber() {
		return patientNationalIdNumber;
	}

	public void setPatientNationalIdNumber(String patientNationalIdNumber) {
		this.patientNationalIdNumber = patientNationalIdNumber;
	}
}
