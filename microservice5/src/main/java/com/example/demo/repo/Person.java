package com.example.demo.repo;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person") // no need to provide as name is asame
@NamedQuery(name="get_all", query="select p from Person p")
public class Person {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name = "birthDate")
	private Date brithDate;
	
	// we need to have no args constructor. for hibername
	public Person() {
			
	}

	public Person(int id, String name, String location, Date brithDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.brithDate = brithDate;
	}
	
	public Person(String name, String location, Date brithDate) {
		super();
		this.name = name;
		this.location = location;
		this.brithDate = brithDate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}
	
	

}
