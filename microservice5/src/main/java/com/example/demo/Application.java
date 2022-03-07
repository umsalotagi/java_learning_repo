package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	// when we add h2 dependency in pom.xml, it is autoconfigured by sprng boot. in traces we can see db name created on our behaf. 
	// data.sql will populate this database
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
