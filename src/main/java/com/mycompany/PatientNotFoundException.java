package com.mycompany;

public class PatientNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 6889175144724384269L;

	public PatientNotFoundException(String nationalIdNumber) {
		super("Paciente no encontrado con DNI: " + nationalIdNumber);
	}
}
