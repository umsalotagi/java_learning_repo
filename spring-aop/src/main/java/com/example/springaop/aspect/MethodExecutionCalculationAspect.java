package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Around("execution(* com.example.springaop.business.*.*(..))")
	// track time only for those method which has @trackTime annotation
	@Around("com.example.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void before(ProceedingJoinPoint joinPoint) throws Throwable { 
		long startTime = System.currentTimeMillis();
		
		// here is issue, not properly returning thing ... 
		joinPoint.proceed(); // this will continue with current method execution around which this code is written
		
		long time = System.currentTimeMillis() - startTime;
		logger.info(" Time taken by {} is {} millisecond ", joinPoint, time);
	}
	
	
}
