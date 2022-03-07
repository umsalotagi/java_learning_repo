package com.example.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
// annotation information is to be available at runtime 
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
	
	

}
