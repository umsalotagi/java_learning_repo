package com.example.springdata.product.hibernateinheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/*
 * Only for SINGLE_TABLE inheritance startegy
 */
//@DiscriminatorValue(value = "ch")

@Table(name = "bankcheck") // this was not needed for SINGLE_TABLE inheritance, only for TABLE_PER_CLASS

/*
 * only for JOINED column strategy
 */
@PrimaryKeyJoinColumn(name = "id")
public class BankCheck extends Payment {
	
	@Column(name = "checknumber")
	private String checkNumber;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

}
