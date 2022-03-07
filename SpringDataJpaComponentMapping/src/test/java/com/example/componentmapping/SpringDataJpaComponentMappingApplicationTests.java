package com.example.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.componentmapping.entities.Address;
import com.example.componentmapping.entities.Employee;
import com.example.componentmapping.repos.EmployeeRepository;

@SpringBootTest
class SpringDataJpaComponentMappingApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	void testCreate() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Bharat");
		Address a = new Address();
		a.setCity("Austin");
		a.setStreetAddress("Spring Woods");
		a.setCountry("USA");
		a.setState("Texas");
		a.setZipcode("78750");
		e.setAddress(a);
		employeeRepository.save(e);
	}

}
