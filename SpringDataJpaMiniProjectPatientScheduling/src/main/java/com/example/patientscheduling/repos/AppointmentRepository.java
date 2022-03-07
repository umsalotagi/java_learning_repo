package com.example.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
