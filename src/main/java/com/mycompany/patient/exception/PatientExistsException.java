package com.mycompany.patient.exception;

import org.springframework.http.HttpStatus;

import com.mycompany.common.exception.MyCompanyException;

public class PatientExistsException extends MyCompanyException{
	private static final long serialVersionUID = 7755643885575186920L;

	private static final String MSG_KEY = "patient.error.alreadyExists";
	
	public PatientExistsException(String nationalIdNumber) {
		super(MSG_KEY, HttpStatus.CONFLICT, nationalIdNumber);
	}
}
