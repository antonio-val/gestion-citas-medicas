package com.mycompany.patient.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.patient.dto.PatientDTO;
import com.mycompany.patient.dto.PatientPartiallyUpdateRequestDTO;
import com.mycompany.patient.dto.PatientSearchRequestDTO;
import com.mycompany.patient.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/pacientes")
public class PatientController {
	private final PatientService patientService;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping
	public List<PatientDTO> getAllPatients () {
		return patientService.getAllPatients();
	}
	
	@PostMapping("/search")
	public PatientDTO getPatientByNationalIdNumber (@Valid @RequestBody PatientSearchRequestDTO search) {
		return patientService.getPatientByNationalIdNumber(search.getNationalIdNumber());
	}
	
	@PostMapping("/create")
	public void createPatient(@Valid @RequestBody PatientDTO patient) {
		patientService.createPatient(patient);
	}
	
	@DeleteMapping
	public void deletePatientByNationalIdNumber(@Valid @RequestBody PatientSearchRequestDTO search) {
		patientService.deletePatientByNationalIdNumber(search.getNationalIdNumber());
	}

	@PutMapping
	public void updatePatientByNationalIdNumber(@Valid @RequestBody PatientDTO patient) {
		patientService.updatePatientByNationalIdNumber(patient);
	}

	@PatchMapping
	public void partiallyUpdatePatientByNationalIdNumber(@Valid @RequestBody PatientPartiallyUpdateRequestDTO patient) {
		patientService.partiallyUpdatePatientByNationalIdNumber(patient);
	}
}
