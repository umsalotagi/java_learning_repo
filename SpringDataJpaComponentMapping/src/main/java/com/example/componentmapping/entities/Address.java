package com.example.componentmapping.entities;

import javax.persistence.Embeddable;
import javax.persistence.Column;

//@Entity we cannot mark a class as entity if it do not have id column
@Embeddable
public class Address {
	
	@Column(name = "streetaddress")
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
