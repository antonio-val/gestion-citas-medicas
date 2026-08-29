package com.mycompany.patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	void deleteByNationalIdNumber(String id);
	boolean existsByNationalIdNumber(String id);
	Optional<Patient> findByNationalIdNumber(String id);
}
