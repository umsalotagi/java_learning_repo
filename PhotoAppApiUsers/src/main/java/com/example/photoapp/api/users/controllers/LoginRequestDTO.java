package com.example.photoapp.api.users.controllers;

import javax.validation.constraints.Email;

// we should not use pathParam and requestParam for this username and pwd as these will be sent as plain text
public class LoginRequestDTO {
	
	@Email
	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
