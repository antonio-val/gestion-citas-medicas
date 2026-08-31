package com.mycompany.patient.service;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.mycompany.patient.dto.PatientCreateRequestDTO;
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
		return repository.findByNationalIdNumber(id).orElseThrow(() -> new PatientNotFoundException("patient.error.nationalIdNumberNotFound", id));
	}

	private Patient getPatientEntity(UUID publicId) {
		return repository.findByPublicId(publicId).orElseThrow(() -> new PatientNotFoundException("patient.error.publicIdNotFound", publicId));
	}

	public PatientDTO createPatient(PatientCreateRequestDTO patientDto) {
		if(repository.existsByNationalIdNumber(patientDto.getNationalIdNumber()))
			throw new PatientExistsException(patientDto.getNationalIdNumber());
		
		Patient patient = patientMapper.toNewEntity(patientDto);
		repository.save(patient);
		
		return patientMapper.toDto(patient);
	}

	@Transactional
	public void deletePatient(UUID publicId) {
		if(!repository.existsByPublicId(publicId))
			throw new PatientNotFoundException("patient.error.publicIdNotFound", publicId);
		
		repository.deleteByPublicId(publicId);
	}

	public PatientDTO updatePatient(UUID publicId, PatientDTO updatedPatient) {
		Patient patient = getPatientEntity(publicId);
		
		patient.setFirstName(updatedPatient.getFirstName());
		repository.save(patient);
		
		return patientMapper.toDto(patient);
	}

	public PatientDTO partiallyUpdatePatient(UUID publicId, PatientPartiallyUpdateRequestDTO updatedPatient) {
		Patient patient = getPatientEntity(publicId);
		
		if(Strings.isNotBlank(updatedPatient.getFirstName()))
			patient.setFirstName(updatedPatient.getFirstName());

		if(Strings.isNotBlank(updatedPatient.getLastName()))
			patient.setLastName(updatedPatient.getLastName());

		repository.save(patient);

		return patientMapper.toDto(patient);
	}
}
