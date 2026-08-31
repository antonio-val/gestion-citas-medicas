package com.mycompany.patient.exception;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class PatientNotFoundException extends MyCompanyException {
	private static final long serialVersionUID = 6889175144724384269L;

	public PatientNotFoundException(String msgKey, Object... args) {
		super(msgKey, HttpStatus.NOT_FOUND, args);
	}
}
