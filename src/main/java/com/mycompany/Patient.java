package com.mycompany;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre es obligatorio.")
	private String firstName;

	@NotBlank(message = "El DNI es obligatorio.")
	@Column(unique = true)
	private String nationalIdNumber;

	public Patient() {
		super();
	}

	public Patient(Long id, String firstName, String nationalIdNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.nationalIdNumber = nationalIdNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, nationalIdNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(nationalIdNumber, other.nationalIdNumber);
	}
}
