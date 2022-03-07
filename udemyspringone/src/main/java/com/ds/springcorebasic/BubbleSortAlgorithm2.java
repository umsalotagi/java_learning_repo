package com.ds.springcorebasic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Parameter 0 of constructor in com.ds.udemyspringone.BinarySearchImp required a bean of type 'com.ds.udemyspringone.SortAlgorithm' that could not be found.
@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm2 implements SortAlgorithm {
	
	public int[] sort(int[] num) {
		
		return num;
	}

}
