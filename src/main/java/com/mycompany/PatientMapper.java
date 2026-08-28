package com.mycompany;

import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
	public PatientDTO toDto(Patient patient) {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setFirstName(patient.getFirstName());
		patientDTO.setNationalIdNumber(patient.getNationalIdNumber());
		
		return patientDTO;
	}
	
	public Patient toNewEntity(PatientDTO patientDto) {
		Patient patient = new Patient();
		patient.setFirstName(patientDto.getFirstName());
		patient.setNationalIdNumber(patientDto.getNationalIdNumber());
		
		return patient;
	}
}
