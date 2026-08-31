package com.mycompany.appointment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		super();
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

	@PostMapping("/create")
	public void createAppointment(@Valid @RequestBody AppointmentCreateRequestDTO appointment) {
		appointmentService.createAppointment(appointment);
	}
	
	@PostMapping("/complete")
	public void completeAppointment(@Valid @RequestBody AppointmentFinishRequestDTO request) {
		appointmentService.completeAppointment(request);
	}

	@PostMapping("/cancel")
	public void cancelAppointment(@Valid @RequestBody AppointmentFinishRequestDTO request) {
		appointmentService.cancelAppointment(request);
	}

	@PatchMapping
	public void partiallyUpdateAppointment(@Valid @RequestBody AppointmentPartiallyUpdateRequestDTO request) {
		appointmentService.partiallyUpdateAppointment(request);
	}
}
