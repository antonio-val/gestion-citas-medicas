package com.mycompany.patient.exception;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class PatientNotFoundException extends MyCompanyException{
	private static final long serialVersionUID = 6889175144724384269L;

	private static final String MSG_KEY = "patient.error.nationalIdNumberNotFound";
	
	public PatientNotFoundException(String nationalIdNumber) {
		super(MSG_KEY, HttpStatus.NOT_FOUND, nationalIdNumber);
	}
}
