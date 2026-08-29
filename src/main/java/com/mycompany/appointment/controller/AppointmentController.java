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

@RestController
@RequestMapping("/api/v1/citas")
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
	public List<AppointmentDTO> getAllAppointmentsByPatientNationalIdNumber(@RequestBody AppointmentSearchRequestDTO search) {
		return appointmentService.getAllAppointmentsByPatientNationalIdNumber(search.getPatientNationalIdNumber());
	}

	@PostMapping("/create")
	public void createAppointment(@RequestBody AppointmentCreateRequestDTO appointment) {
		appointmentService.createAppointment(appointment);
	}
	
	@PostMapping("/complete")
	public void completeAppointment(@RequestBody AppointmentFinishRequestDTO request) {
		appointmentService.completeAppointment(request);
	}

	@PostMapping("/cancel")
	public void cancelAppointment(@RequestBody AppointmentFinishRequestDTO request) {
		appointmentService.cancelAppointment(request);
	}

	@PatchMapping
	public void partiallyUpdateAppointment(@RequestBody AppointmentPartiallyUpdateRequestDTO request) {
		appointmentService.partiallyUpdateAppointment(request);
	}
}
