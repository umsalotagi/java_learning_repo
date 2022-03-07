package com.example.associations.onetoone.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	/*
	 * Two types of onetoone association:
	 * 1. shared primary key : bidirectional : both table share same primary key. this is used when both table will always have associated value in next table.
	 * e.g. both person and library memebership. its bi-directional. all person will have library membership. and membership will be having person associated with it.
	 * 2. foreign key type of association. foreign key is to be stored in table for which next column is has to have.
	 * e.g. uni-directional: Person cannot have license but license is always associated with person.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// camel case automatically converted to snake case in spring data. 
	// this will become first_name
	private String firstName;
	private String lastName;
	private int age;
	
	// mappedBy is property name from main Table (here License table) which maps this relationship
	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	private License license;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	
	

}
