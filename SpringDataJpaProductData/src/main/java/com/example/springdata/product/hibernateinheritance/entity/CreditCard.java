package com.example.springdata.product.hibernateinheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/*
 * Only for SINGLE_TABLE inheritance startegy
 */
//@DiscriminatorValue(value = "cc")

//sql converts Camel case to snake case by default. to avoid it either use Creditcard or Table annotation
//this was not needed for SINGLE_TABLE inheritance, only for TABLE_PER_CLASS
@Table(name = "card") 

/*
 * only for JOINED column startegy
 */
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment {
	
	@Column(name = "cardnumber")
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	

}
