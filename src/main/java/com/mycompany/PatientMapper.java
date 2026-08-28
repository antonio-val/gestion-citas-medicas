package com.mycompany;

import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
	public PatientDTO toDto(Patient patient) {
		PatientDTO patientDto = new PatientDTO();
		patientDto.setFirstName(patient.getFirstName());
		patientDto.setLastName(patient.getLastName());
		patientDto.setNationalIdNumber(patient.getNationalIdNumber());
		
		return patientDto;
	}
	
	public Patient toNewEntity(PatientDTO patientDto) {
		Patient patient = new Patient();
		patient.setFirstName(patientDto.getFirstName());
		patient.setLastName(patientDto.getLastName());
		patient.setNationalIdNumber(patientDto.getNationalIdNumber());
		
		return patient;
	}
}
