package com.ds.udemyspringone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ds.udemyspringone.basic.BinarySearchImp;
import com.ds.udemyspringone.cdi.SomeCDIBusiness;

@SpringBootApplication
public class UdemySpringCDIApplication {

	public static void main(String[] args) {
		
		// CDI - container (context) and dependency injection
		// CDI is java EE standard
		
		// similar to JPA, then we use its implementation Hybernate
		
		// whether you use spring annotation or CDI annotation it does not matter as spring implements CDI
		
		/**
		 * for this exercise we added following dependency in pom.xml
		 * 		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
		 */
		ApplicationContext applicationContext = SpringApplication.run(UdemySpringCDIApplication.class, args);
		
		SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);
		System.out.println(someCDIBusiness);
		System.out.println(someCDIBusiness.getSomeCdiDAO());
	}

}
