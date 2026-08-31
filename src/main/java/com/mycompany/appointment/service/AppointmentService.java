package com.mycompany.appointment.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import com.mycompany.appointment.dto.AppointmentCreateRequestDTO;
import com.mycompany.appointment.dto.AppointmentDTO;
import com.mycompany.appointment.dto.AppointmentFinishRequestDTO;
import com.mycompany.appointment.dto.AppointmentPartiallyUpdateRequestDTO;
import com.mycompany.appointment.exception.NotModifiedAppointmentException;
import com.mycompany.appointment.exception.AppointmentNotFoundException;
import com.mycompany.appointment.exception.OverlappingAppointmentException;
import com.mycompany.appointment.mapper.AppointmentMapper;
import com.mycompany.appointment.model.Appointment;
import com.mycompany.appointment.model.AppointmentStatus;
import com.mycompany.appointment.repository.AppointmentRepository;
import com.mycompany.patient.exception.PatientNotFoundException;
import com.mycompany.patient.model.Patient;
import com.mycompany.patient.repository.PatientRepository;

@Service
public class AppointmentService {
	private final AppointmentRepository appointmentRepository;
	private final AppointmentMapper appointmentMapper;
	private final PatientRepository patientRepository;
	
	public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper,
			PatientRepository patientRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.appointmentMapper = appointmentMapper;
		this.patientRepository = patientRepository;
	}

	public List<AppointmentDTO> getAllAppointments() {
		return appointmentRepository.findAll().stream().map(a -> appointmentMapper.toDto(a)).toList();
	}
	
	public List<AppointmentDTO> getAllAppointmentsBy() {
		return appointmentRepository.findAll().stream().map(a -> appointmentMapper.toDto(a)).toList();
	}

	public List<AppointmentDTO> getAllAppointmentsByPatientNationalIdNumber(String id) {
		return appointmentRepository.findByPatientNationalIdNumber(id).stream().map(a -> appointmentMapper.toDto(a)).toList();
	}

	public void createAppointment(AppointmentCreateRequestDTO appointmentDto) {
		Patient patient = getPatient(appointmentDto);
		Appointment appointment = appointmentMapper.toNewAppointment(appointmentDto, patient);

		if(appointmentRepository.existsOverlappingAppointment(appointment.getStartDateTime(), appointment.getEndDateTime()))
			throw new OverlappingAppointmentException(appointment.getStartDateTime(), appointment.getEndDateTime());
		
		appointmentRepository.save(appointment);
	}
	
	private Patient getPatient(AppointmentCreateRequestDTO appointment) {
		return patientRepository.findByPublicId(appointment.getPatientPublicId()).orElseThrow(() -> new PatientNotFoundException("patient.error.publicIdNotFound", appointment.getPatientPublicId()));
	}

	public void completeAppointment(UUID publicId, AppointmentFinishRequestDTO request) {
		finishAppointment(publicId, request, AppointmentStatus.COMPLETED);
	}
	
	private void finishAppointment(UUID publicId, AppointmentFinishRequestDTO request, AppointmentStatus status) {
		Appointment appointment = getAppointment(publicId);
		appointment.setStatus(status);

		if(Strings.isNotBlank(request.getFinalNotes()))
			appointment.setFinalNotes(request.getFinalNotes());

		appointmentRepository.save(appointment);
	}
	
	private Appointment getAppointment(UUID id) {
		return appointmentRepository.findByPublicId(id).orElseThrow(() -> new AppointmentNotFoundException(id));
	}

	public void cancelAppointment(UUID publicId, AppointmentFinishRequestDTO request) {
		finishAppointment(publicId, request, AppointmentStatus.CANCELLED);
	}

	public void partiallyUpdateAppointment(UUID publicId, AppointmentPartiallyUpdateRequestDTO request) {
		Appointment appointment = getAppointment(publicId);

		if(isAppointmentFinished(appointment)) {
			String msgKey = "appointment.error.finishedAppointmentCannotBeModified";
			throw new NotModifiedAppointmentException(msgKey, appointment.getId(), appointment.getStatus());
		}
		
		LocalDateTime start = getUpdatedStart(appointment, request);
		LocalDateTime end = getUpdatedEnd(appointment, request);
		boolean timesHaveChanged = !start.equals(appointment.getStartDateTime()) ||
				!end.equals(appointment.getEndDateTime());
		if(timesHaveChanged) {
			if(appointmentRepository.existsOverlappingAppointmentExcludingSelf(start, end, appointment.getId()))
				throw new OverlappingAppointmentException(start, end);
			
			appointment.setStartDateTime(start);
			appointment.setEndDateTime(end);
		}
		
		if(request.getReason() != null)
			appointment.setReason(request.getReason());
		if(Strings.isBlank(appointment.getReason()))
			appointment.setReason(null);
		
		if(request.getFinalNotes() != null)
			appointment.setFinalNotes(request.getFinalNotes());
		if(Strings.isBlank(appointment.getFinalNotes()))
			appointment.setFinalNotes(null);
		
		if(request.getStatus() != null)
			appointment.setStatus(request.getStatus());
		
		appointmentRepository.save(appointment);
	}
	
	private LocalDateTime getUpdatedStart(Appointment appointment, AppointmentPartiallyUpdateRequestDTO request) {
		return request.getStart() != null ? request.getStart() : appointment.getStartDateTime();
	}

	private LocalDateTime getUpdatedEnd(Appointment appointment, AppointmentPartiallyUpdateRequestDTO request) {
		LocalDateTime start = getUpdatedStart(appointment, request);
		
		LocalDateTime end;
		if(request.getStart() != null || request.getDuration() != null) {
			int minutes = request.getDuration() != null ? request.getDuration() : (int) Duration.between(request.getStart(), appointment.getEndDateTime()).toMinutes();
			end = start.plusMinutes(minutes);
		} else {
			end = appointment.getEndDateTime();
		}
		
		return end;
	}

	private boolean isAppointmentFinished(Appointment appointment) {
		return appointment.getStatus() == AppointmentStatus.COMPLETED || appointment.getStatus() == AppointmentStatus.CANCELLED;
		
	}
}
