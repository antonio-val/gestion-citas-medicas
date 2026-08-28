package com.mycompany;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class PatientsService {
	private PatientsRepository repository;
	private PatientMapper patientMapper;
	
	public PatientsService(PatientsRepository repository, PatientMapper patientMapper) {
		super();
		this.repository = repository;
		this.patientMapper = patientMapper;
	}

	public List<PatientDTO> getAllPatients() {
		return repository.findAll().stream().map(p -> patientMapper.toDto(p)).toList();
	}

	public PatientDTO getPatientByNationalIdNumber(String id) {
		Patient patient = getPatientEntityByNationalIdNumber(id);
		
		return patientMapper.toDto(patient);
	}

	private Patient getPatientEntityByNationalIdNumber(String id) {
		return repository.findByNationalIdNumber(id).orElseThrow(() -> new IllegalStateException("DNI " + id + " no encontrado"));
	}

	public void addPatient(PatientDTO patientDto) {
		Patient patient = patientMapper.toNewEntity(patientDto);
		repository.save(patient);
	}

	public void deletePatient(String id) {
		Patient patient = getPatientEntityByNationalIdNumber(id);
		repository.delete(patient);
	}

	public void updatePatient(String id, PatientDTO updatedPatient) {
		Patient patient = getPatientEntityByNationalIdNumber(id);
		
		patient.setFirstName(updatedPatient.getFirstName());
		repository.save(patient);
	}

	public void partiallyUpdatePatient(String id, PatientDTO updatedPatient) {
		Patient patient = getPatientEntityByNationalIdNumber(id);
		
		if(Strings.isNotBlank(updatedPatient.getFirstName()))
			patient.setFirstName(updatedPatient.getFirstName());

		repository.save(patient);
	}
}
