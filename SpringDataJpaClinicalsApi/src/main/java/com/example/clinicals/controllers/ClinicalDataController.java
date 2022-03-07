package com.example.clinicals.controllers;

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

import com.example.clinicals.dto.ClinicalDataRequestDTO;
import com.example.clinicals.model.ClinicalData;
import com.example.clinicals.model.Patient;
import com.example.clinicals.repos.ClinicalDataRepository;
import com.example.clinicals.repos.PatientRepository;

@RestController
@RequestMapping(value = "/api/clinicals")
@CrossOrigin
public class ClinicalDataController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ClinicalDataRepository clinicalDataRepository;
	
	@PostMapping
	public ResponseEntity<ClinicalData> saveClinicalData(@RequestBody ClinicalDataRequestDTO request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData cd = new ClinicalData();
		cd.setComponentName(request.getComponentName()); // we can use mapped here
		cd.setComponentvalue(request.getComponentValue());
		cd.setPatient(patient);
		return new ResponseEntity<ClinicalData>(clinicalDataRepository.save(cd), HttpStatus.OK);
	}

}
