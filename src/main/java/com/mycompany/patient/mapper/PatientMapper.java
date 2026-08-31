package com.mycompany.patient.mapper;

import org.springframework.stereotype.Component;

import com.mycompany.patient.dto.PatientCreateRequestDTO;
import com.mycompany.patient.dto.PatientDTO;
import com.mycompany.patient.model.Patient;

@Component
public class PatientMapper {
	public PatientDTO toDto(Patient patient) {
		PatientDTO patientDto = new PatientDTO();
		patientDto.setPublicId(patient.getPublicId());
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

	public Patient toNewEntity(PatientCreateRequestDTO patientDto) {
		Patient patient = new Patient();
		patient.setFirstName(patientDto.getFirstName());
		patient.setLastName(patientDto.getLastName());
		patient.setNationalIdNumber(patientDto.getNationalIdNumber());

		return patient;
	}
}
