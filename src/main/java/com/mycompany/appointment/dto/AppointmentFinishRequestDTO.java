package com.mycompany.appointment.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class AppointmentFinishRequestDTO {
	@NotNull(message = "{appointment.error.publicIdMandatory}")
	private UUID publicId;
	private String finalNotes;

	public AppointmentFinishRequestDTO(UUID publicId, String finalNotes) {
		super();
		this.publicId = publicId;
		this.finalNotes = finalNotes;
	}

	public UUID getPublicId() {
		return publicId;
	}

	public void setId(UUID publicId) {
		this.publicId = publicId;
	}

	public String getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(String finalNotes) {
		this.finalNotes = finalNotes;
	}



}
