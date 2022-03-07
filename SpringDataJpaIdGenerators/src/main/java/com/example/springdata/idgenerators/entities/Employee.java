package com.example.springdata.idgenerators.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	
	// by default id is Long for hybernate.
	
	
	// create table employee(id int PRIMARY KEY AUTO_INCREMENT,name varchar(20));
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@TableGenerator(name="employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	@GenericGenerator(name = "emp_id", strategy = "com.example.springdata.idgenerators.CustonRandomIDGenerators")
	@GeneratedValue(generator="emp_id")
	@Id
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
