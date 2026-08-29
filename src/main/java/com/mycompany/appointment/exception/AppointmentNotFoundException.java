package com.mycompany.appointment.exception;

public class AppointmentNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 6889175144724384269L;

	public AppointmentNotFoundException(Long id) {
		super("Cita no encontrada con id: " + id);
	}
}
