package com.ds.springcorebasic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.ds.udemyspringone.BinarySearchImp' available
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // String type scope is not preferred "prototype"
public class BinarySearchImp2 {
	
	private Logger logger = LoggerFactory.getLogger(BinarySearchImp2.class);
	
	// could not found any error even when this Autowired  annotation is removed
	@Autowired
	@Qualifier("bubble") // Qualifier is given first preference, highest than primary.
	private SortAlgorithm bubbleSortAlgorithm; // autowiring by name
	// if @Primary is given to different component, that component is first preferred.
	
	// constructor injection. 
	// Autowiring by type from bean name 'binarySearchImp' via constructor to bean named 'quickSortAlgorithm'
//	public BinarySearchImp(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}
	
	// setter injection
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.bubbleSortAlgorithm = sortAlgorithm;
//	}
	
	// No setter and constructor injection. work same as setter injection

	public int binarySearch( int[] array, int num) {
		
		// first sort
		// BubbleSortAlgorithm bubbleSort = new BubbleSortAlgorithm();
		int[] sortedNum = bubbleSortAlgorithm.sort(array);
		System.out.println(bubbleSortAlgorithm);
		
		
		
		// then do binary search
		
		// return the result
		return 3;
	}
	
	// as soon as bean is created and initialized with dependencies, this PostConstruct function is called
	@PostConstruct
	public void createConnection() {
		logger.info("*******Post construct springCore.BinarySearchImp2 function called .... in createConnection Function");
	}
	
	// just before bean is destroyed. before bean is removed out of context
	// used as callback on instances is in process of removal 
	@PreDestroy
	public void preDestroyFunction() {
		// still NOT ABLE to work and print this result
		// TO DO
		logger.info("##########pre destroy springCore.BinarySearchImp2 ");
	}

}
