package com.mycompany.patient.model;

import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "patients")
@SQLDelete(sql = "UPDATE patient SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{patient.error.publicIdMandatory}")
	@Column(name = "public_id", unique = true, updatable = false)
	private UUID publicId = UUID.randomUUID();

	@NotBlank(message = "{patient.error.firstNameMandatory}")
	@Length(max = 50)
	private String firstName;

	@NotBlank(message = "{patient.error.lastNameMandatory}")
	@Length(max = 100)
	private String lastName;

	@NotBlank(message = "{patient.error.nationalIdNumberMandatory}")
	@Column(unique = true, length = 20)
	private String nationalIdNumber;

	@NotNull(message = "{patient.error.deletedMandatory}")
	private boolean deleted = false;
	
	public Patient() {
		// Empty
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getPublicId() {
		return publicId;
	}

	public void setPublicId(UUID publicId) {
		this.publicId = publicId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(publicId);
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
		return Objects.equals(publicId, other.publicId);
	}
}
