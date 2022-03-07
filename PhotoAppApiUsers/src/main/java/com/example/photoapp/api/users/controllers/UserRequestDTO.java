package com.example.photoapp.api.users.controllers;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDTO {
	
	@NotNull(message = "First Name cannot be null")
	@Size(min=3, message = "First Name cannot be less than 3 characters")
	private String firstName;
	
	@NotNull
	@Size(min=3)
	private String lastName;
	
	@NotNull
	@Size(min=6, max=16, message = "password must be in 6 to 16 characters.")
	private String password;
	
	@NotNull
	@Email
	private String email;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
