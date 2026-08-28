package com.mycompany;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("{id}")
	public PatientDTO getPatientByNationalIdNumber (@PathVariable String id) {
		return patientsService.getPatientByNationalIdNumber(id);
	}
	
	@PostMapping
	public void addPatient(@RequestBody PatientDTO patient) {
		patientsService.addPatient(patient);
	}
	
	@DeleteMapping("{id}")
	public void deletePatientByNationalIdNumber(@PathVariable String id) {
		patientsService.deletePatientByNationalIdNumber(id);
	}

	@PutMapping("{id}")
	public void updatePatientByNationalIdNumber(@PathVariable String id, @RequestBody PatientDTO patient) {
		patientsService.updatePatientByNationalIdNumber(id, patient);
	}

	@PatchMapping("{id}")
	public void partiallyUpdatePatientByNationalIdNumber(@PathVariable String id, @RequestBody PatientDTO patient) {
		patientsService.partiallyUpdatePatientByNationalIdNumber(id, patient);
	}
}
