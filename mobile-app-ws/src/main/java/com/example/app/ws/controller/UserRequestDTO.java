package com.example.app.ws.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDTO {
	
	@NotNull
	@Size(min=4)
	private String name;
	@Min(18)
	private int age;
	@NotNull
	private String address;
	@Email
	@NotNull(message="email cannot be null")
	private String email;
	
	public UserRequestDTO(String name, int age, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
