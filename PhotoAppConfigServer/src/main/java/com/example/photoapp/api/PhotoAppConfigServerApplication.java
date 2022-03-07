package com.example.photoapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
 * when there RE LOTS OF config files to manage microservices, we can use config server to maintain config properties of m
 * microservice spring boot app. we are using bit backend for this config server to store config files
 * config files from git server will have higher priority. we can still provide some properties in local config file. but central config 
 * will have higher priority. 
 * 
 *  we can name properties in git server as :
 *  1. application.properties     : more priority than local properties file
 *  2. microservicename.properties : more priority tahn 1 
 *  3. microservicename-profileName.properties   : highest priority
 */

/*
 * need to add bootstarp application file. this will load before local application config file. even before creation of java beans.
 * in new version you does not need to do it
 * just add following perperty in application.properties file
 * spring.config.import
 * 
 * spring cloud bus - to receive dynamic changes in properties file, without needing to re-start microservice -> by using SQS
 * 
 * trace id : for entire request
 * span id : for one machine
 * sleuth : label logging information with id
 * zipkin : present this info in GUI
 */

@SpringBootApplication
@EnableConfigServer
public class PhotoAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppConfigServerApplication.class, args);
	}

}
