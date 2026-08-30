package com.mycompany.appointment.exception;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class AppointmentNotFoundException extends MyCompanyException {
	private static final long serialVersionUID = 6889175144724384269L;

	private static final String MSG_KEY = "appointment.error.idNotFound";

	public AppointmentNotFoundException(Long id) {
		super(MSG_KEY, HttpStatus.NOT_FOUND, id);
	}
}
