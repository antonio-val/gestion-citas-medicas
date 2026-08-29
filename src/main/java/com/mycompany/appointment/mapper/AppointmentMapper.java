package com.mycompany.appointment.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.mycompany.appointment.dto.AppointmentCreateRequestDTO;
import com.mycompany.appointment.dto.AppointmentDTO;
import com.mycompany.appointment.model.Appointment;
import com.mycompany.appointment.model.AppointmentStatus;
import com.mycompany.patient.model.Patient;

@Component
public class AppointmentMapper {
	public AppointmentDTO toDto(Appointment appointment) {
		AppointmentDTO appointmentDto = new AppointmentDTO();
		appointmentDto.setId(appointment.getId());
		appointmentDto.setStart(appointment.getStartDateTime());
		appointmentDto.setEnd(appointment.getEndDateTime());
		appointmentDto.setReason(appointment.getReason());
		appointmentDto.setFinalNotes(appointment.getFinalNotes());
		appointmentDto.setStatus(appointment.getStatus());
		appointmentDto.setPatientFirstName(appointment.getPatient().getFirstName());
		appointmentDto.setPatientLastName(appointment.getPatient().getLastName());
		appointmentDto.setPatientNationalIdNumber(appointment.getPatient().getNationalIdNumber());
		
		return appointmentDto;
	}

	public Appointment toNewAppointment(AppointmentCreateRequestDTO appointmentDto, Patient patient) {
		Appointment appointment = new Appointment();
		appointment.setStartDateTime(appointmentDto.getStart());
		appointment.setEndDateTime(getEnd(appointmentDto));
		appointment.setReason(appointmentDto.getReason());
		appointment.setStatus(AppointmentStatus.SCHEDULED);
		appointment.setPatient(patient);
		
		return appointment;
	}
	
	private LocalDateTime getEnd(AppointmentCreateRequestDTO appointmentDto) {
		return appointmentDto.getStart().plusMinutes(appointmentDto.getDurationMinutes());
	}
}
