package com.ds.udemyspringone.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.ds.udemyspringone.SortAlgorithm' available: expected single matching bean but found 2: bubbleSortAlgorithm,quickSortAlgorithm
//@Primary 
@Service
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] num) {
		
		return num;
	}

}
