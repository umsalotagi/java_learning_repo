package com.example.app.ws.controller;

import javax.validation.constraints.NotNull;

public class UpdateUserRequestDTO {
	
	@NotNull
	private String address;
	@NotNull
	private int age;
	
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}

}
