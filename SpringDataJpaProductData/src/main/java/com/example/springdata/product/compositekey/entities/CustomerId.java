package com.example.springdata.product.compositekey.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/*
 * composite key is key made of two or more columns. 
 * We are creating Key class which is of two column for which we want to create composite key
 * Every key class should implement Serializable interface
 * NO Entity annotation needed for key class.
 */
@Embeddable // needed for second was of creating composite key
public class CustomerId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
