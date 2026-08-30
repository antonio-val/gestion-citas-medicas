package com.mycompany.appointment.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentCreateRequestDTO {
	@NotNull(message = "{appointment.error.startMandatory}")
	private LocalDateTime start;
	@NotNull(message = "{appointment.error.durationMandatory}")
	private Integer durationMinutes;
	private String reason;
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String patientNationalIdNumber;

	public AppointmentCreateRequestDTO(LocalDateTime start, Integer durationMinutes, String reason, String patientNationalIdNumber) {
		super();
		this.start = start;
		this.durationMinutes = durationMinutes;
		this.reason = reason;
		this.patientNationalIdNumber = patientNationalIdNumber;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public Integer getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPatientNationalIdNumber() {
		return patientNationalIdNumber;
	}

	public void setPatientNationalIdNumber(String patientNationalIdNumber) {
		this.patientNationalIdNumber = patientNationalIdNumber;
	}}
