package com.example.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
