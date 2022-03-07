package com.example.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdata.idgenerators.entities.Employee;
import com.example.springdata.idgenerators.repos.EmployeeRespository;

@SpringBootTest
class SpringDataJpaIdGeneratorsApplicationTests {
	
	@Autowired
	EmployeeRespository er;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateEmployee() {
		Employee employee = new Employee();
		//employee.setId(3564L);
		employee.setName("John");
		er.save(employee);
		
	}

}
