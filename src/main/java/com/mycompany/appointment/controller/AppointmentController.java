package com.mycompany.appointment.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<AppointmentDTO> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@PostMapping("/search")
	public List<AppointmentDTO> getAllAppointmentsByPatientNationalIdNumber(@Valid @RequestBody AppointmentSearchRequestDTO search) {
		return appointmentService.getAllAppointmentsByPatientNationalIdNumber(search.getPatientNationalIdNumber());
	}

	@PostMapping
	public AppointmentDTO createAppointment(@Valid @RequestBody AppointmentCreateRequestDTO appointment) {
		return appointmentService.createAppointment(appointment);
	}
	
	@PatchMapping("/{publicId}/complete")
	public AppointmentDTO completeAppointment(@PathVariable UUID publicId, @Valid @RequestBody AppointmentFinishRequestDTO request) {
		return appointmentService.completeAppointment(publicId, request);
	}

	@PatchMapping("/{publicId}/cancel")
	public AppointmentDTO cancelAppointment(@PathVariable UUID publicId, @Valid @RequestBody AppointmentFinishRequestDTO request) {
		return appointmentService.cancelAppointment(publicId, request);
	}

	@PatchMapping("/{publicId}")
	public AppointmentDTO partiallyUpdateAppointment(@PathVariable UUID publicId, @Valid @RequestBody AppointmentPartiallyUpdateRequestDTO request) {
		return appointmentService.partiallyUpdateAppointment(publicId, request);
	}
}
