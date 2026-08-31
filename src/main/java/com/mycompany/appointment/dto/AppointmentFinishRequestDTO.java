package com.mycompany.appointment.dto;

public class AppointmentFinishRequestDTO {
	private String finalNotes;

	public AppointmentFinishRequestDTO(String finalNotes) {
		this.finalNotes = finalNotes;
	}

	public String getFinalNotes() {
		return finalNotes;
	}

	public void setFinalNotes(String finalNotes) {
		this.finalNotes = finalNotes;
	}
}
