package com.example.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
