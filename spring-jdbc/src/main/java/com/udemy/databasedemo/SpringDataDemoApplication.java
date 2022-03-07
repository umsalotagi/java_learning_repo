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
import com.udemy.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository;

	@Override
	public void run(String... args) throws Exception {
		logger.info(" user 10002: {}" , repository.findById(10002));
		

		// with this extend of interface all duplicate functions are auto created. 
		// such ad save, findById, deleteById
		// we can get all following function without coding them
		
		logger.info(" updating person 10004: updated no of rows :{}" , repository.save(new Person(10004, "Umesh", "Pune", new Date())));
		
		// id given to rajanikant will not be considered as JPA we written to auto generate od
		// so even though we provided id, it will auto generate it, 
		// so id of following row will be 1
		logger.info(" Inserting new person 10025: updated no of row :{}" , repository.save(new Person(10025, "Rajanikant", "Tamilnadu", new Timestamp(new Date().getTime()))));
		logger.info(" Inserting new person 10005: updated no of row :{}" , repository.save(new Person( "Rajanikant", "Tamilnadu", new Timestamp(new Date().getTime()))));
		repository.deleteById(10002);
		
		logger.info("List of person in table {}", repository.findAll());
	}
	
	/*
	 * connecting to other database.
	 * just add databse connector in pom.xml, get list of properties to be defined to connect to database
	 * e.g. username p, pwd
	 * 
	 * spring.jpa.hibernate.ddl-auto : create (hybernate will create database schema for you as per entities), 
	 * none (you will create schema manually by sql)
	 * for this exmaple, we manually created schema with file schema.sql and added data with file data.sql
	 * as hybernate creating schema did not work properly even putting above property as create
	 */

}
