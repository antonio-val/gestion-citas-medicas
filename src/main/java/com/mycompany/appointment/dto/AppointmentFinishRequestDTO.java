package com.mycompany.appointment.dto;

import jakarta.validation.constraints.NotBlank;

public class AppointmentFinishRequestDTO {
	@NotBlank
	private Long id;
	private String finalNotes;

	public AppointmentFinishRequestDTO(Long id, String finalNotes) {
		super();
		this.id = id;
		this.finalNotes = finalNotes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(String finalNotes) {
		this.finalNotes = finalNotes;
	}



}
