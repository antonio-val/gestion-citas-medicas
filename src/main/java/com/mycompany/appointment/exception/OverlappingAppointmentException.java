package com.mycompany.appointment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class OverlappingAppointmentException extends MyCompanyException{
	private static final long serialVersionUID = -4858691153021388251L;

	private static final String MSG_KEY = "appointment.error.overlapping";

	public OverlappingAppointmentException(LocalDateTime start, LocalDateTime end) {
		super(MSG_KEY, HttpStatus.CONFLICT, start, end);
	}
}
