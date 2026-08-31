package com.mycompany.appointment.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mycompany.appointment.model.AppointmentStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public class AppointmentPartiallyUpdateRequestDTO {
	@NotNull(message = "{appointment.error.publicIdMandatory}")
	private UUID publicId;
	@Future(message = "{appointment.error.startInFutureMandatory}")
	private LocalDateTime start;
	private Integer duration;
	private String reason;
	private String finalNotes;
	private AppointmentStatus status;

	public AppointmentPartiallyUpdateRequestDTO() {
		super();
	}

	public UUID getPublicId() {
		return publicId;
	}

	public void setId(UUID id) {
		this.publicId = id;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(String finalNotes) {
		this.finalNotes = finalNotes;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
}
