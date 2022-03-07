package com.example.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
