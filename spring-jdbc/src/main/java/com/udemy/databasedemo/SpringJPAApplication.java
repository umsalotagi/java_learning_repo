package com.udemy.databasedemo;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.databasedemo.entity.Person;
import com.udemy.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJPAApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		System.out.println("working gooood...................................");
		SpringApplication.run(SpringJPAApplication.class, args);
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info(" user 10002: {}" , personJpaRepository.findById(10002));

		logger.info(" updating person 10004: updated no of rows :{}" , personJpaRepository.update(new Person(10004, "Umesh", "Pune", new Date())));
		// id given to rajanikant will not be considered as JPA we written to auto generate od
		// so even though we provided id, it will auto generate it, 
		// so id of following row will be 1
		logger.info(" Inserting new person 10005: updated no of row :{}" , personJpaRepository.insert(new Person(10025, "Rajanikant", "Tamilnadu", new Timestamp(new Date().getTime()))));
		logger.info(" Inserting new person 10005: updated no of row :{}" , personJpaRepository.insert(new Person( "Rajanikant", "Tamilnadu", new Timestamp(new Date().getTime()))));
		personJpaRepository.deleteById(10002);
		
		logger.info("List of person in table {}", personJpaRepository.findAll());
	}

}
