package com.mycompany;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patient, Integer> {
	Optional<Patient> findByNationalIdNumber(String nationalIdNumber);
}
