package com.udemy.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.udemy.databasedemo.entity.Person;
import com.udemy.databasedemo.jdbc.PersonJdbcDAO;

// just commented to run only JPA 
//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
	
	/* Spring boot starter dependencies :
	 * JDBC :
	 * JPA : what we can do with JDBC can also be done with JPA
	 * H2 : In memory SQL database. http://localhost:8080/h2-console
	 * Web : for web application 
	 * 
	 * play around it with debug mode and check auto configuration to know how JDBCTemplate get configured
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users : {} ", dao.findAll());
		logger.info(" user 10004: {}" , dao.find(10004));
		logger.info(" user 10002: no of rows deleted : {}" , dao.deleteById(10002));
		logger.info(" Inserting new person 10005: updated no of row :{}" , dao.insert(new Person(10005, "Rajanikant", "Tamilnadu", new Date())));
		logger.info(" updating person 10003: updated no of rows :{}" , dao.update(new Person(10004, "Umesh", "Pune", new Date())));
	}

}
