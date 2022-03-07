package com.example.springdata.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdata.product.hibernateinheritance.entity.BankCheck;
import com.example.springdata.product.hibernateinheritance.entity.CreditCard;
import com.example.springdata.product.hibernateinheritance.repos.PaymentRespository;

@SpringBootTest
public class HybernateInheritanceTest {
	
	@Autowired
	PaymentRespository paymentRespository;
	
	@Test
	void createPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(2000);
		cc.setCardNumber("4566");
		paymentRespository.save(cc);
	}
	
	@Test
	void createCheckPayment() {
		BankCheck cc = new BankCheck();
		cc.setId(3);
		cc.setAmount(3000);
		cc.setCheckNumber("5674");
		paymentRespository.save(cc);
	}

}
