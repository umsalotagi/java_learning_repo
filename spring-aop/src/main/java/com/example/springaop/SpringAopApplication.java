package com.example.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.springaop.business.Business1;
import com.example.springaop.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {
	/*
	 * Spring AOP dependency removed from spring 2, we need to add following dependency in pom
	 * 
	 *  <dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
		
		implementation of AOP : Aspect Oriented Programming for cross cutting concern
		1. spring-aop :  one of popular, intercept any calls to bean
		2. aspectJweaver : more powerful, can intercept change of field also
	 */
	
	// using slf4j log
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private  Business1 business1;
	
	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApplication.class, args);
		// following line is executed after run 
		System.out.println("This is .............");
		
	}
	
	// invoked as sson as application is launched

	@Override
	public void run(String... args) throws Exception {
		logger.info(business1.calculateSomething());
		logger.info(business2.calculateSomething());
	}

}
