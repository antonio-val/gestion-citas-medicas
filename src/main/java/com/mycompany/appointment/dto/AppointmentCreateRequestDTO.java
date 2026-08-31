package com.mycompany.appointment.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class AppointmentCreateRequestDTO {
	@NotNull(message = "{appointment.error.startMandatory}")
	private LocalDateTime start;
	@NotNull(message = "{appointment.error.durationMandatory}")
	private Integer durationMinutes;
	private String reason;
	@NotNull(message = "{patient.error.publicIdMandatory}")
	private UUID patientPublicId;

	public AppointmentCreateRequestDTO(LocalDateTime start, Integer durationMinutes, String reason, UUID patientPublicId) {
		this.start = start;
		this.durationMinutes = durationMinutes;
		this.reason = reason;
		this.patientPublicId = patientPublicId;
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

	public UUID getPatientPublicId() {
		return patientPublicId;
	}

	public void setPatientPublicId(UUID patientPublicId) {
		this.patientPublicId = patientPublicId;
	}
}
