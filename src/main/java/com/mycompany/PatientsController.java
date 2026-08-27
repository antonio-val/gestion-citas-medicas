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
	public List<Patient> getAllPatients () {
		return patientsService.getAllPatients();
	}
	
	@GetMapping("{id}")
	public Patient getPatientByNationalIdNumber (@PathVariable String nationalIdNumber) {
		return patientsService.getPatientByNationalIdNumber(nationalIdNumber);
	}
	
	@PostMapping
	public void addPatient(@RequestBody Patient patient) {
		patientsService.addPatient(patient);
	}
	
	@DeleteMapping("{id}")
	public void deletePatient(@PathVariable String id) {
		patientsService.deletePatient(id);
	}

	@PutMapping("{id}")
	public void updatePatient(@PathVariable String id, @RequestBody Patient patient) {
		patientsService.updatePatient(id, patient);
	}

	@PatchMapping("{id}")
	public void partiallyUpdatePatient(@PathVariable String id, @RequestBody Patient patient) {
		patientsService.partiallyUpdatePatient(id, patient);
	}
}
