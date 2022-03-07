package com.example.springdata.product.compositekey.entities;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "customer2")
//one way it to provide Id class and keep id and email field with @Id annotation
//@IdClass(CustomerId.class) 
public class Customer {
	/*
	 * easy JPQL query, but data get repeated and some more annotation get added
	 * select c.email from Customer c
	 */
//	@Id
//	private int id;
//	@Id
//	private String email;
	
	@EmbeddedId
	/*
	 * easy and much more readable, but getting id with jpql will be little long 
	 * select c.customerId.email from Customer c
	 */
	private CustomerId id;
	private String name;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CustomerId getId() {
		return id;
	}
	public void setId(CustomerId id) {
		this.id = id;
	}
}
