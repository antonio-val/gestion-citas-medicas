package com.mycompany.appointment.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.appointment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByPatientNationalIdNumber(String id);

	Optional<Appointment> findByPublicId(UUID publicId);

	boolean existsByStartDateTime(LocalDateTime start);

	@Query("""
			    SELECT COUNT(a) > 0 FROM Appointment a
			    WHERE a.status != 'CANCELLED'
			    AND a.startDateTime < :newEnd
			    AND a.endDateTime > :newStart
			""")
	boolean existsOverlappingAppointment(@Param("newStart") LocalDateTime newStart,
			@Param("newEnd") LocalDateTime newEnd);

	@Query("""
			    SELECT COUNT(a) > 0 FROM Appointment a
			    WHERE a.status != 'CANCELLED'
			    AND a.id != :currentAppointmentId
			    AND a.startDateTime < :newEnd
			    AND a.endDateTime > :newStart
			""")
	boolean existsOverlappingAppointmentExcludingSelf(@Param("newStart") LocalDateTime newStart,
			@Param("newEnd") LocalDateTime newEnd, @Param("currentAppointmentId") Long currentAppointmentId);
}
