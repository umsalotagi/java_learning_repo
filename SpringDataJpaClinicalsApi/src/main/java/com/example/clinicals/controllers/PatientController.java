package com.example.clinicals.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinicals.model.ClinicalData;
import com.example.clinicals.model.Patient;
import com.example.clinicals.repos.PatientRepository;

@RestController
@RequestMapping(value = "/api/patients")
@CrossOrigin // as front-end will run on different port.
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatients() {
		return new ResponseEntity<List<Patient>>(patientRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<Patient> getPatient(@PathVariable("userId") int userId) {
		return new ResponseEntity<Patient>(patientRepository.findById(userId).get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient p) {
		return new ResponseEntity<Patient>(patientRepository.save(p), HttpStatus.OK);
	}
	
	@GetMapping(value = "/analyze/{id}")
	public ResponseEntity<Patient> analyze(@PathVariable("id") int id) {
		Patient patient = patientRepository.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalData();
		Set<String> dataDupCheck = new HashSet<>();
		final ClinicalData cdhw;
		List<ClinicalData> collect = clinicalData.stream().filter(cd -> {
			// checking unique
			if (dataDupCheck.contains(cd.getComponentName())) {
				System.out.println("cd rejected "+ cd.getId());
				System.out.println(dataDupCheck);
				return false;
			} else {
				dataDupCheck.add(cd.getComponentName());
				System.out.println("******* cd accepted "+ cd.getId());
				System.out.println(dataDupCheck);
				return true;
			}
			
		}).map(cd -> {
			System.out.println("##### cd mapped "+ cd.getComponentName());
			if (!cd.getComponentName().equals("hw")) return cd;
			String[] split = cd.getComponentvalue().split("/");
			// add checks to split may be through filters
			if (split != null && split.length>1) {
				float heightInMeters = Float.parseFloat(split[0]) * 0.4536F;
				float bmi = Float.parseFloat(split[1]) / (heightInMeters*heightInMeters);
				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentvalue(Float.toString(bmi));
				//cdhw = cd;
				return bmiData;
			} else {
				return cd;
			}
		}).collect(Collectors.toList());
		patient.setClinicalData(collect);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

}
