package com.mycompany;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/gestion-citas-medicas")
public class PatientsController {
	private PatientsService patientsService;
	
	public PatientsController(PatientsService patientsService) {
		super();
		this.patientsService = patientsService;
	}

	@GetMapping
	public List<PatientDTO> getAllPatients () {
		return patientsService.getAllPatients();
	}
	
	@PostMapping("/search")
	public PatientDTO getPatientByNationalIdNumber (@RequestBody PatientDTO patient) {
		return patientsService.getPatientByNationalIdNumber(patient.getNationalIdNumber());
	}
	
	@PostMapping("/create")
	public void createPatient(@RequestBody PatientDTO patient) {
		patientsService.createPatient(patient);
	}
	
	@DeleteMapping
	public void deletePatientByNationalIdNumber(@RequestBody PatientDTO patient) {
		patientsService.deletePatientByNationalIdNumber(patient.getNationalIdNumber());
	}

	@PutMapping
	public void updatePatientByNationalIdNumber(@RequestBody PatientDTO patient) {
		patientsService.updatePatientByNationalIdNumber(patient);
	}

	@PatchMapping
	public void partiallyUpdatePatientByNationalIdNumber(@RequestBody PatientDTO patient) {
		patientsService.partiallyUpdatePatientByNationalIdNumber(patient);
	}
}
