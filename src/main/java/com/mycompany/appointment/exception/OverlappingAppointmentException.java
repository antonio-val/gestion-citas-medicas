package com.mycompany.appointment.exception;

import java.time.LocalDateTime;

public class OverlappingAppointmentException extends RuntimeException{
	private static final long serialVersionUID = -4858691153021388251L;

	public OverlappingAppointmentException(LocalDateTime start, LocalDateTime end) {
		super("Hay otra cita en el tramo horario dado. Comienzo: " + start + "; Final: " + end);
	}
}
