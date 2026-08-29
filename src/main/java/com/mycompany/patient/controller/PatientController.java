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
import com.mycompany.patient.dto.PatientPartiallyUpdateDTO;
import com.mycompany.patient.dto.PatientSearchRequestDTO;
import com.mycompany.patient.service.PatientService;

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
	public PatientDTO getPatientByNationalIdNumber (@RequestBody PatientSearchRequestDTO search) {
		return patientService.getPatientByNationalIdNumber(search.getNationalIdNumber());
	}
	
	@PostMapping("/create")
	public void createPatient(@RequestBody PatientDTO patient) {
		patientService.createPatient(patient);
	}
	
	@DeleteMapping
	public void deletePatientByNationalIdNumber(@RequestBody PatientSearchRequestDTO search) {
		patientService.deletePatientByNationalIdNumber(search.getNationalIdNumber());
	}

	@PutMapping
	public void updatePatientByNationalIdNumber(@RequestBody PatientDTO patient) {
		patientService.updatePatientByNationalIdNumber(patient);
	}

	@PatchMapping
	public void partiallyUpdatePatientByNationalIdNumber(@RequestBody PatientPartiallyUpdateDTO patient) {
		patientService.partiallyUpdatePatientByNationalIdNumber(patient);
	}
}
