package com.ds.unittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MockitoSpringApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(MockitoSpringApplication.class, args);
		
		SomeBusinessImpl bu = applicationContext.getBean(SomeBusinessImpl.class);
		

	}

}
