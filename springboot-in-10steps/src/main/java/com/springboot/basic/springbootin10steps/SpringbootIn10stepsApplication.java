package com.springboot.basic.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//this annotation enables auto-configures and enables automatic scan of package for beans
@SpringBootApplication
public class SpringbootIn10stepsApplication {
	
	// spring boot loks at 1. FWs available on classpath 2. existing beans which are configured app
	// this is called auto configuration
	
	// this is spring starter project - chosen 'Web' as dependency. So it is spring web starter project
	// this starter project are ready to use configuration
	public static void main(String[] args) {
		SpringApplication.run(SpringbootIn10stepsApplication.class, args);
	}
	
	// spring : FW takes control of all beans and their dependency. Dependency Injection.
	// spring MVC : provides simple way of develop web application. separation concern : dispatcher servelet, modelAndView and view resolver 
	// spring boot : auto configuration of some of beans as per FW module chosen. when spring web mvc is choosed, spring boot auto configures it.	
	
	/*
	 * <dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-browser</artifactId>
			<version>3.3.5.RELEASE</version>
		</dependency>
		
	 spring-boot-starter-actuator : used for monitoring and tracing application out of box
	 spring-boot-starter-loggin, spring-boot-starter-log4j
	 this will expose lot of REST API as per HAL standard,  http://localhost:8080/browser/index.html browser to see APIs exposed by actuator
	 http://localhost:8080/actuator  
	 with actuator we can manage many things by activating through application properties
	 activating lot of tracker will reduce performance
	 spring tools eclipse plugin help in application properties suggestion. if we misspell in properties this will tell us.	
	 */
	
	// spring-boot-starter-web : for building web application, REST api. it is another pom.xml file we can see in details contains
	// ::: spring-boot-starter-tomcat
	
	// spring-boot-strter-jpa : jpa is kind of interface for hybernate. how ORM fw should work.
	// object relation mapping. has dependency of : sring boot aop, jdbc , hybernate, tracsaction	, spring data jpa

}
