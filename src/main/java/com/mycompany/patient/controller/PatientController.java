package com.mycompany.patient.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<PatientDTO>> getAllPatients() {
		List<PatientDTO> patients = patientService.getAllPatients();

		return ResponseEntity.ok(patients);
	}

	@PostMapping("/search")
	public ResponseEntity<PatientDTO> getPatientByNationalIdNumber(@Valid @RequestBody PatientSearchRequestDTO search) {
		PatientDTO patient = patientService.getPatientByNationalIdNumber(search.getNationalIdNumber());

		return ResponseEntity.ok(patient);
	}

	@PostMapping
	public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientCreateRequestDTO patient) {
		PatientDTO newPatient = patientService.createPatient(patient);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{publicId}")
				.buildAndExpand(newPatient.getPublicId()).toUri();

		return ResponseEntity.created(location).body(newPatient);
	}

	@DeleteMapping("/{publicId}")
	public ResponseEntity<Void> deletePatient(@PathVariable UUID publicId) {
		patientService.deletePatient(publicId);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{publicId}")
	public ResponseEntity<PatientDTO> updatePatient(@PathVariable UUID publicId, @Valid @RequestBody PatientDTO patient) {
		PatientDTO updatedPatient = patientService.updatePatient(publicId, patient);

		return ResponseEntity.ok(updatedPatient);
	}

	@PatchMapping("/{publicId}")
	public ResponseEntity<PatientDTO> partiallyUpdatePatient(@PathVariable UUID publicId,
			@Valid @RequestBody PatientPartiallyUpdateRequestDTO patient) {
		PatientDTO updatedPatient = patientService.partiallyUpdatePatient(publicId, patient);

		return ResponseEntity.ok(updatedPatient);
	}
}
