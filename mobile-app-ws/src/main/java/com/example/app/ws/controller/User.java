package com.example.app.ws.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
//@Builder(builderClassName = "Builder", builderMethodName = "build")
@Builder
@NoArgsConstructor
public class User {
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	private String name;
	public User(String name, int age, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.setEmail(email);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	private int age;
	public void setAge(int age) {
		this.age = age;
	}
	private String address;
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;
	private String uuid;
	
}
