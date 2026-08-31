package com.mycompany.patient.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	void deleteByPublicId(UUID publicId);
	boolean existsByNationalIdNumber(String id);
	boolean existsByPublicId(UUID publicId);
	Optional<Patient> findByNationalIdNumber(String id);
	Optional<Patient> findByPublicId(UUID publicId);
}
