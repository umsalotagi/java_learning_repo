package com.example.associations;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.associations.onetoone.entities.License;
import com.example.associations.onetoone.entities.Person;
import com.example.associations.onetoone.repos.LicenseRepository;
import com.example.associations.onetoone.repos.PersonRepository;

@SpringBootTest
public class OneToOneAssociationTest {
	
	@Autowired
	LicenseRepository licenseRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Test
	void createLicense() {
		License entity = new License();
		entity.setType("Car");
		entity.setValidFrom(new Date());
		entity.setValidTo(new Date());
		
		Person p = new Person();
		p.setFirstName("John");
		p.setLastName("Cena");
		p.setAge(35);
		entity.setPerson(p);
		licenseRepository.save(entity);
	}
	
	@Test
	void createPersonWithLicense() {
		// note that FK is stored in License table
		Person p = new Person();
		p.setFirstName("Khali");
		p.setLastName("Cena");
		p.setAge(35);
		
		License entity = new License();
		entity.setType("Bike");
		entity.setValidFrom(new Date());
		entity.setValidTo(new Date());
		
		// in this case, FK will be stored as null in License table
		entity.setPerson(p); //  this is one way, other way being modifying setter to add this
		p.setLicense(entity);
		
		personRepository.save(p);
		
	}

}
