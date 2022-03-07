package com.example.associations;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.associations.manytomany.entities.Programmer;
import com.example.associations.manytomany.entities.Project;
import com.example.associations.manytomany.repos.ProgrammerRepository;

@SpringBootTest
public class ManyToManyAssociationTest {
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Test
	void createProgrammer() {
		Programmer entity = new Programmer();
		entity.setName("John");
		entity.setSalary(300000);
		
		Set<Project> pro = new HashSet<>();
		Project p = new Project();
		p.setName("Hybernate Project");
		pro.add(p);
		entity.setProjects(pro);
		
		programmerRepository.save(entity);
	}
	
	@Test
	//@Transactional
	void testFindProgrammer() {
		Programmer programmer = programmerRepository.findById(1).get();
		System.out.println(programmer);
		// throws LazyIntializationException if not annotated with Transaction for default lazy loaded association
		// two queries one with data and other with join are called with lazy loading
		System.out.println(programmer.getProjects()); 
	}
	
	
}
