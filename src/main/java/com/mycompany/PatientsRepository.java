package com.mycompany;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patient, Integer> {
	void deleteByNationalIdNumber(String nationalIdNumber);
	boolean existsByNationalIdNumber(String nationalIdNumber);
	Optional<Patient> findByNationalIdNumber(String nationalIdNumber);
}
