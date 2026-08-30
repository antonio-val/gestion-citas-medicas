package com.mycompany.appointment.exception;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class NotModifiedAppointmentException extends MyCompanyException {
	private static final long serialVersionUID = -217374932275293276L;

	public NotModifiedAppointmentException(String msgKey, Object... args) {
		super(msgKey, HttpStatus.CONFLICT, args);
	}

}
