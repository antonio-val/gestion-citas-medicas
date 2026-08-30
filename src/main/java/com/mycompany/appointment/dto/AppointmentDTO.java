package com.mycompany.appointment.dto;

import java.time.LocalDateTime;

import com.mycompany.appointment.model.AppointmentStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentDTO {
	@NotNull(message = "{appointment.error.idMandatory}")
	private Long id;
	@NotNull(message = "{appointment.error.startMandatory}")
	private LocalDateTime start;
	@NotNull(message = "{appointment.error.endMandatory}")
	private LocalDateTime end;
	private String reason;
	private String finalNotes;
	@NotNull(message = "{appointment.error.statusMandatory}")
	private AppointmentStatus status;
	@NotBlank(message = "{patient.error.firstNameMandatory}")
	private String patientFirstName;
	@NotBlank(message = "{patient.error.lastNameMandatory}")
	private String patientLastName;
	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	private String patientNationalIdNumber;

	public AppointmentDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
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

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientNationalIdNumber() {
		return patientNationalIdNumber;
	}

	public void setPatientNationalIdNumber(String patientNationalIdNumber) {
		this.patientNationalIdNumber = patientNationalIdNumber;
	}
}
