package com.mycompany.patient.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.patient.dto.PatientCreateRequestDTO;
import com.mycompany.patient.dto.PatientDTO;
import com.mycompany.patient.dto.PatientPartiallyUpdateRequestDTO;
import com.mycompany.patient.dto.PatientSearchRequestDTO;
import com.mycompany.patient.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController {
	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping
	public List<PatientDTO> getAllPatients() {
		return patientService.getAllPatients();
	}

	@PostMapping("/search")
	public PatientDTO getPatientByNationalIdNumber(@Valid @RequestBody PatientSearchRequestDTO search) {
		return patientService.getPatientByNationalIdNumber(search.getNationalIdNumber());
	}

	@PostMapping
	public PatientDTO createPatient(@Valid @RequestBody PatientCreateRequestDTO patient) {
		return patientService.createPatient(patient);
	}

	@DeleteMapping("/{publicId}")
	public void deletePatient(@PathVariable UUID publicId) {
		patientService.deletePatient(publicId);
	}

	@PutMapping("/{publicId}")
	public PatientDTO updatePatient(@PathVariable UUID publicId, @Valid @RequestBody PatientDTO patient) {
		return patientService.updatePatient(publicId, patient);
	}

	@PatchMapping("/{publicId}")
	public PatientDTO partiallyUpdatePatient(@PathVariable UUID publicId,
			@Valid @RequestBody PatientPartiallyUpdateRequestDTO patient) {
		return patientService.partiallyUpdatePatient(publicId, patient);
	}
}
