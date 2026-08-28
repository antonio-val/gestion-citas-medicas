package com.mycompany;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patient, Integer> {
	void deleteByNationalIdNumber(String id);
	boolean existsByNationalIdNumber(String id);
	Optional<Patient> findByNationalIdNumber(String id);
}
