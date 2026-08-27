package com.mycompany;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class PatientsService {
	private PatientsRepository repository;

		public PatientsService(PatientsRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Patient> getAllPatients() {
		return repository.findAll();
	}

	public Patient getPatientByNationalIdNumber(String id) {
		return repository.findByNationalIdNumber(id).orElseThrow(() -> new IllegalStateException("DNI " + id + " no encontrado"));
	}

	public void addPatient(Patient patient) {
		repository.save(patient);
	}

	public void deletePatient(String id) {
		Patient patient = getPatientByNationalIdNumber(id);
		repository.delete(patient);
	}

	public void updatePatient(String id, Patient updatedPatient) {
		Patient patient = getPatientByNationalIdNumber(id);
		
		patient.setFirstName(updatedPatient.getFirstName());
		patient.setNationalIdNumber(updatedPatient.getNationalIdNumber());
		repository.save(patient);
	}

	public void partiallyUpdatePatient(String id, Patient updatedPatient) {
		Patient patient = getPatientByNationalIdNumber(id);
		
		if(Strings.isNotBlank(updatedPatient.getFirstName()))
			patient.setFirstName(updatedPatient.getFirstName());
		
		if(Strings.isNotBlank(updatedPatient.getNationalIdNumber()))
			patient.setNationalIdNumber(updatedPatient.getNationalIdNumber());

		repository.save(patient);
	}
}
