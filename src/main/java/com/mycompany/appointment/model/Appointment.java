package com.mycompany.appointment.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.mycompany.patient.model.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{appointment.error.publicIdMandatory}")
	@Column(name = "public_id", unique = true, updatable = false)
	private UUID publicId = UUID.randomUUID();

	@Column(name = "start_date_time")
	@NotNull(message = "{appointment.error.startMandatory}")
	private LocalDateTime startDateTime;

	@Column(name = "end_date_time")
	@NotNull(message = "{appointment.error.endMandatory}")
	private LocalDateTime endDateTime;

	@Length(max = 255)
	private String reason;

	@Length(max = 255)
	private String finalNotes;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@NotNull(message = "{appointment.error.statusMandatory}")
	private AppointmentStatus status;
	
	@NotNull(message = "{appointment.error.patientMandatory}")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn
	private Patient patient;

	public Appointment() {
		super();
	}

	public Appointment(Long id, UUID publicId, LocalDateTime start, LocalDateTime end, String reason, String finalNotes, AppointmentStatus status, Patient patient) {
		super();
		this.id = id;
		this.publicId = publicId;
		this.startDateTime = start;
		this.endDateTime = end;
		this.reason = reason;
		this.finalNotes = finalNotes;
		this.status = status;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getPublicId() {
		return publicId;
	}

	public void setPublicId(UUID publicId) {
		this.publicId = publicId;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime start) {
		this.startDateTime = start;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime end) {
		this.endDateTime = end;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDateTime, finalNotes, id, patient, publicId, reason, startDateTime, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(endDateTime, other.endDateTime) && Objects.equals(finalNotes, other.finalNotes)
				&& Objects.equals(id, other.id) && Objects.equals(patient, other.patient)
				&& Objects.equals(publicId, other.publicId) && Objects.equals(reason, other.reason)
				&& Objects.equals(startDateTime, other.startDateTime) && status == other.status;
	}
}
