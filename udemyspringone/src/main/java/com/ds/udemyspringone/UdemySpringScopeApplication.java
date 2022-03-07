package com.ds.udemyspringone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ds.udemyspringone.scope.PersonDAO;

@SpringBootApplication
public class UdemySpringScopeApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UdemySpringScopeApplication.class);
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(UdemySpringScopeApplication.class, args);
		
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		
		// by default any bean is singleton 
		// when PersonDAO is Prototype scope, only object of PersonDAO is newly created, but its dependency remains singleton
		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());
		LOGGER.info("{}", personDAO.getJdbcConnection());
		// even on same instance of person we get new instance of jdbc in each call
		LOGGER.info("{}", personDAO2);
		
		// if we keep PersonDAO as Singleton and its dependency as Prototype, still it create single object for dependency.
		// to change it we need to use proxy
		
		LOGGER.info("{}", personDAO2.getJdbcConnection());
		
		//Scope of Bean : Singleton ( one per application context) , Prototype (new bean whenever requested)
		// request (one bean per HTTP request), session (one bean  per HTTP user session)
		
		// difference between singleton in spring vs singleton in Gang of Four(GoF) design pattern
		// in GoF single instance is created per entire JVM
		
		
	}

}
