package com.example.demo.controller;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // only needed for response 
public class PersonDao {
	
	private int id;
	
	@NotNull
	private String name;
	
	private String location;
	
	private Date brithDate;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public Date getBrithDate() {
		return brithDate;
	}
	
}
