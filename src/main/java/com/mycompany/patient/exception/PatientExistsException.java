package com.mycompany.patient.exception;

public class PatientExistsException extends RuntimeException{
	private static final long serialVersionUID = 7755643885575186920L;

	public PatientExistsException(String nationalIdNumber) {
		super("Ya existe un paciente con DNI: " + nationalIdNumber);
	}
}
