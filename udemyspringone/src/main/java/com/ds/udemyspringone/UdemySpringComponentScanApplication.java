package com.ds.udemyspringone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.ds.componentscan.ComponentDAO;
import com.ds.udemyspringone.scope.PersonDAO;

@SpringBootApplication
@ComponentScan("com.ds.componentscan")
public class UdemySpringComponentScanApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UdemySpringComponentScanApplication.class);
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(UdemySpringComponentScanApplication.class, args);
		
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
		LOGGER.info("{}", componentDAO);
		
		// @SpringBootApplication is present in package com.ds.udemyspringone; so it will scan for component 
		// in packages and subpackages of this package. if one component is present in different package then
		// No qualifying bean of type 'com.ds.componentscan.ComponentDAO' available ... is thrown
		
		// to hadle it we need to add @ComponentScan annotation

	}

}
