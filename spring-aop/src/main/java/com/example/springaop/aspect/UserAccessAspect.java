package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// What kind of method calls I would intercept
	// execution( * PACKAGE.*.*(..) )   // first * : any return type  // this is pointcut
	// second * any class          third * any method      .. is any no of arguments 
	
	// combination of pointcut and Advice is Aspect
	// jointPoint specific interception of method call data
	// expression is pointcut : which decides which methods to be intercepted is pointcut
	// process of implementing AOP around method call is weaving , and FW which implements weaving is weaver
	@Before("execution(* com.example.springaop.data.*.*(..))")
	public void before(JoinPoint jointPoint) { // logic here is Advice
		// here security is defined at single place and it is applied to all api in business layer
		logger.info(" Checking fo user access ");
		logger.info(" Allowed execution for {} ", jointPoint);
	}
	
	
}
