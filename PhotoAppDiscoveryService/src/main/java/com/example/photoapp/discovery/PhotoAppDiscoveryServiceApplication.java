package com.example.photoapp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * Eureaka helps microservice find each other
 * to communicate with microservice we need to know its domain name. we cna hard code it but when services scale this will be issue
 * when each instance of microservice starts up it will register itself with eureka discovery service. 
 * Eureka will know address of each service. once new instance of microservice starts, it will register to eureka by itself.
 */


@SpringBootApplication
@EnableEurekaServer // to make this app run as Eureka server, also some changes need to do in application.properties
public class PhotoAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppDiscoveryServiceApplication.class, args);
	}

}
