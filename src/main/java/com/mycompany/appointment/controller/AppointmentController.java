package com.mycompany.appointment.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mycompany.appointment.dto.AppointmentCreateRequestDTO;
import com.mycompany.appointment.dto.AppointmentDTO;
import com.mycompany.appointment.dto.AppointmentFinishRequestDTO;
import com.mycompany.appointment.dto.AppointmentPartiallyUpdateRequestDTO;
import com.mycompany.appointment.dto.AppointmentSearchRequestDTO;
import com.mycompany.appointment.service.AppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@GetMapping
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
		List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
		
		return ResponseEntity.ok(appointments);
	}

	@PostMapping("/search")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointmentsByPatientNationalIdNumber(
			@Valid @RequestBody AppointmentSearchRequestDTO search) {
		List<AppointmentDTO> appointments = appointmentService.getAllAppointmentsByPatientNationalIdNumber(search.getPatientNationalIdNumber());

		return ResponseEntity.ok(appointments);
	}

	@PostMapping
	public ResponseEntity<AppointmentDTO> createAppointment(@Valid @RequestBody AppointmentCreateRequestDTO appointment) {
		AppointmentDTO newAppointment = appointmentService.createAppointment(appointment);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{publicId}")
				.buildAndExpand(newAppointment.getPublicId()).toUri();

		return ResponseEntity.created(location).body(newAppointment);
	}

	@PatchMapping("/{publicId}/complete")
	public ResponseEntity<AppointmentDTO> completeAppointment(@PathVariable UUID publicId,
			@Valid @RequestBody AppointmentFinishRequestDTO request) {
		AppointmentDTO appointment = appointmentService.completeAppointment(publicId, request);

		return ResponseEntity.ok(appointment);
	}

	@PatchMapping("/{publicId}/cancel")
	public ResponseEntity<AppointmentDTO> cancelAppointment(@PathVariable UUID publicId,
			@Valid @RequestBody AppointmentFinishRequestDTO request) {
		AppointmentDTO appointment = appointmentService.cancelAppointment(publicId, request);

		return ResponseEntity.ok(appointment);
	}

	@PatchMapping("/{publicId}")
	public ResponseEntity<AppointmentDTO> partiallyUpdateAppointment(@PathVariable UUID publicId,
			@Valid @RequestBody AppointmentPartiallyUpdateRequestDTO request) {
		AppointmentDTO appointment = appointmentService.partiallyUpdateAppointment(publicId, request);

		return ResponseEntity.ok(appointment);
	}
}
