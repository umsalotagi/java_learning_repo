package com.example.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

/*
 * Best practices in AOP, having all pointcut in one common file
 */

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.example.springaop.business.*.*(..))")
	public void businessLayerExecution() {};
	
	@Pointcut("execution(* com.example.springaop.data.*.*(..))")
	public void dataLayerExecution() {};
	
	@Pointcut("com.example.springaop.aspect.CommonJoinPointConfig.businessLayerExecution() "
			+ "&& com.example.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	public void allLeayerExecution() {};
	
	@Pointcut("bean(*Dao*)")
	public void beanContainingDao() {};
	
	@Pointcut("within(com.example.springaop.data..*)")
	public void DataLayerExecutionWithWithin() {};
	
	@Pointcut("@annotation(com.example.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {};

}
