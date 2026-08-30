package com.mycompany.patient.service;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.mycompany.patient.dto.PatientDTO;
import com.mycompany.patient.dto.PatientPartiallyUpdateRequestDTO;
import com.mycompany.patient.exception.PatientExistsException;
import com.mycompany.patient.exception.PatientNotFoundException;
import com.mycompany.patient.mapper.PatientMapper;
import com.mycompany.patient.model.Patient;
import com.mycompany.patient.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
public class PatientService {
	private final PatientRepository repository;
	private final PatientMapper patientMapper;
	
	public PatientService(PatientRepository repository, PatientMapper patientMapper) {
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
		return repository.findByNationalIdNumber(id).orElseThrow(() -> new PatientNotFoundException(id));
	}

	public void createPatient(PatientDTO patientDto) {
		if(repository.existsByNationalIdNumber(patientDto.getNationalIdNumber()))
			throw new PatientExistsException(patientDto.getNationalIdNumber());
		
		Patient patient = patientMapper.toNewEntity(patientDto);
		repository.save(patient);
	}

	@Transactional
	public void deletePatientByNationalIdNumber(String id) {
		if(!repository.existsByNationalIdNumber(id))
			throw new PatientNotFoundException(id);
		
		repository.deleteByNationalIdNumber(id);
	}

	public void updatePatientByNationalIdNumber(PatientDTO updatedPatient) {
		Patient patient = getPatientEntityByNationalIdNumber(updatedPatient.getNationalIdNumber());
		
		patient.setFirstName(updatedPatient.getFirstName());
		repository.save(patient);
	}

	public void partiallyUpdatePatientByNationalIdNumber(PatientPartiallyUpdateRequestDTO updatedPatient) {
		Patient patient = getPatientEntityByNationalIdNumber(updatedPatient.getNationalIdNumber());
		
		if(Strings.isNotBlank(updatedPatient.getFirstName()))
			patient.setFirstName(updatedPatient.getFirstName());

		if(Strings.isNotBlank(updatedPatient.getLastName()))
			patient.setLastName(updatedPatient.getLastName());

		repository.save(patient);
	}
}
