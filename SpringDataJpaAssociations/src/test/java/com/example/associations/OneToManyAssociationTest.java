package com.example.associations;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.associations.onetomany.entities.Customer;
import com.example.associations.onetomany.entities.PhoneNumber;
import com.example.associations.onetomany.repos.CustomerRepository;

@SpringBootTest
public class OneToManyAssociationTest {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void testCreateCustomer() {
		Customer c = new Customer();
		c.setName("Bharat");
		
		//HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		PhoneNumber p = new PhoneNumber();
		p.setType("Cell");
		p.setNumber("089837645678");
		
		// this line of code is necessary to have column "customer_id" populated with id of customer.
		// otherwise when we do save on Customer, "customer_id" column of PhoneNumber will be null.
		//p.setCustomer(c); 
		//numbers.add(p);
		c.addPhoneNumber(p);
		
		PhoneNumber p1 = new PhoneNumber();
		p1.setType("Home");
		p1.setNumber("97645364785");
		
		//p1.setCustomer(c);
		//numbers.add(p1);
		//c.setNumbers(numbers);
		c.addPhoneNumber(p1);
		
		customerRepository.save(c);
		
	}
	
	@Test
	@Transactional // needed for lazy loading to work. from org.springframework
	void testLoadCustomer() {
		Customer customer = customerRepository.findById(4L).get();
		System.out.println(customer.getName());
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		// following line throws LazyInitilizationException. 
		System.out.println("..." + numbers.size());
		numbers.forEach(no -> System.out.println(no.getNumber()));
	}
	
	@Test
	void testUpdateCustomer() {
		Customer customer = customerRepository.findById(4L).get();
		customer.setName("Geoge Washington");
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(no -> no.setType("cell"));
		customerRepository.save(customer);
	}
	
	@Test
	void testDeleteCustomer() {
		// cascade effect, it will delete from both Customer as well as its Phone numbers from database.
		customerRepository.deleteById(4L);
	}

}
