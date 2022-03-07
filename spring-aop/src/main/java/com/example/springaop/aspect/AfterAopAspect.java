package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect
@Configuration
public class AfterAopAspect {
	
	/*
	 * What are the things you can do in after aspect
	 * 
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(value="com.example.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", returning="result")
	public void afterReturning(JoinPoint joinPoint , Object result) {
		logger.info(" Allowed execution for {} , returned {} ", joinPoint, result);	
	}
	
	@AfterThrowing(value="com.example.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()", throwing="result")
	public void afterThrowing(JoinPoint joinPoint , Object result) {
		logger.info(" Allowed execution for {} , returned {} ", joinPoint, result);	
	}
	
	// whether its return something or throw exception, in all cases this is executed
	@After(value="com.example.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info(" Allowed execution ** {} , returned {} ", joinPoint);	
	}
	
}
