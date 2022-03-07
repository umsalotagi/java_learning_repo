package com.example.springdata.product.hibernateinheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
/*
 * Inheritance Type : SINGLE_TABLE, all data is stored in single table with discriminator column.
 */
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)

/*
 * TABLE_PER_CLASS : table for each child class. no table for parent class. not recommended, as it duplicates data across different table.
 * as Payment data is common for both check and ceditCard, it will duplicate the data of Payment in both 
 * check and credit card table for this TABLE_PER_CLASS inheritance. fling normalization rules. but improves performance
 */
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

/*
 * JOINED strategy : most used. it is table fir each class, including parent class. Payment, check, creditcrad.
 * donot need desciminator column. follows normalization. minimum data in table.
 * cons : hybernate will need to join table.
 */
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
	
	@Id
	private int id;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
