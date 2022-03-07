package com.example.photoapp.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	
	// list of address of running microservices, spring cloud API gateway will fetch from Eureka Discovery service
	// you can use filteres in API gateway. use this filteres for logging certain request, 
	// validation by reading http header and validate JWT token
	// configure custom routing, change request to send further 
	// there can be pre filteres (before request made) and post filters (after request made)
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
