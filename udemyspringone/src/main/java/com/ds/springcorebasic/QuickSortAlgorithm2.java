package com.ds.springcorebasic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.ds.udemyspringone.SortAlgorithm' available: expected single matching bean but found 2: bubbleSortAlgorithm,quickSortAlgorithm
//@Primary 
@Component
@Qualifier("quick")
public class QuickSortAlgorithm2 implements SortAlgorithm{
	
	public int[] sort(int[] num) {
		
		return num;
	}

}
