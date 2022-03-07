package com.example.patientscheduling;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.patientscheduling.entities.Appointment;
import com.example.patientscheduling.entities.Doctor;
import com.example.patientscheduling.entities.Insurance;
import com.example.patientscheduling.entities.Patient;
import com.example.patientscheduling.repos.AppointmentRepository;
import com.example.patientscheduling.repos.DoctorRepository;
import com.example.patientscheduling.repos.PatientRepository;

@SpringBootTest
class SpringDataJpaMiniProjectPatientSchedulingApplicationTests {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	void testCreateDoctor() {
		Doctor doc = new Doctor();
		doc.setFirstName("John");
		doc.setLastName("Cena");
		doc.setSpeciality("Pediatrician");
		doctorRepository.save(doc);
	}
	
	@Test
	void testCreateDoctor2() {
		Doctor doc = new Doctor();
		doc.setFirstName("John2");
		doc.setLastName("Cena2");
		doc.setSpeciality("Pediatrician2");
		doctorRepository.save(doc);
	}
	
	@Test
	void testCreatePatient() {
		Patient p = new Patient();
		p.setFirstName("Rahul");
		p.setLastName("Kanjare");
		p.setPhone("1234567890");
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Bajaj Insuarance");
		insurance.setCopay(20d);
		p.setInsurance(insurance);
		
		Doctor doctor = doctorRepository.findById(1L).get();
		p.setDoctors(Arrays.asList(doctor));
		
		patientRepository.save(p);
	}
	
	@Test
	void testCreateAppointment() {
		Appointment appointment = new Appointment();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		appointment.setAppintmentTime(timestamp);
		appointment.setReason("I have problem");
		appointment.setStarted(true);
		
		Patient patient = patientRepository.findById(1L).get();
		appointment.setPatient(patient);
		
		Doctor doctor = doctorRepository.findById(1L).get();
		appointment.setDoctor(doctor);
		
		appointmentRepository.save(appointment);
	}
	
	@Test
	void testCreateAppointment2() {
		Appointment appointment = new Appointment();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		appointment.setAppintmentTime(timestamp);
		appointment.setReason("I have problem");
		appointment.setStarted(true);
		
		Patient patient = patientRepository.findById(1L).get();
		appointment.setPatient(patient);
		
		// also need to add doctor in patient to get this info
		Doctor doctor = doctorRepository.findById(2L).get();
		appointment.setDoctor(doctor);
		
		appointmentRepository.save(appointment);
	}
	
	@Test
	@Transactional
	void getDataFromPatient() {
		// 1 hybernate query
		//patientRepository.findById(1L).get().getDoctors().forEach(x-> System.out.println(x));
		System.out.println("**************"); // 2+ queries for each
		//doctorRepository.findById(1L).get().getPatients().forEach(System.out::println);
		System.out.println("**************"); // 2+ queries for each
		//doctorRepository.findById(2L).get().getAppointments().forEach(System.out::println);
		System.out.println("**************"); // 2 queries
		patientRepository.findById(1L).get().getAppointments().forEach(System.out::println);
	}

}
