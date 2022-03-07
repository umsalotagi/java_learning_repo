package com.example.demo.controller;


import java.net.http.HttpResponse;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.example.demo.repo.Person;
import com.example.demo.repo.PersonJPARepo;
import com.example.demo.repo.PersonRepository;

@RestController
@RequestMapping(value = "/users")
public class FirstApi {
	/*
	 * The simplest way for my understanding is, the @ModelAttribute will take a query string. 
	 * so, all the data are being pass to the server through the url.
	 * As for @RequestBody, all the data will be pass to the server through a full JSON body.
	 * RequestParam, requestBody, pathvariabl
	 */
	
	// Spring Hybernate JPA repository
	@Autowired
	private PersonRepository personRepo;
	
	// Spring Data JPA repository
	//@Autowired
	//private PersonJPARepo personRepo;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		return new ResponseEntity(personRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> onePerson(@PathVariable int id) {
		log.info("This is data {} ", id);
		return new ResponseEntity<Person> (personRepo.findById(id).get(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deletePerson(@PathVariable int id) {
		personRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Person> addPerson(@Valid @RequestBody PersonDao person) {
		Person p = personRepo.save(new Person(person.getId(), person.getName(), person.getLocation(), person.getBrithDate()));
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}
	
	

}
