package com.example.springdata.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdata.product.compositekey.entities.Customer;
import com.example.springdata.product.compositekey.entities.CustomerId;
import com.example.springdata.product.compositekey.repos.CustomerRepo;

@SpringBootTest
public class CompositeKeyTest {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Test
	void testSaveCustomer() {
		Customer c = new Customer();
//		c.setId(1234);
//		c.setEmail("exmaple@example.com");
		CustomerId id = new CustomerId();
		id.setId(2345);
		id.setEmail("one@exmaple.com");
		c.setId(id);
		c.setName("Test");
		customerRepo.save(c);
	}

}
