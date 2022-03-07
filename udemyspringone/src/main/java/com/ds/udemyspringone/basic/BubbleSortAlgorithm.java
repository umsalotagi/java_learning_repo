package com.ds.udemyspringone.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Parameter 0 of constructor in com.ds.udemyspringone.BinarySearchImp required a bean of type 'com.ds.udemyspringone.SortAlgorithm' that could not be found.
@Service
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
	
	public int[] sort(int[] num) {
		
		return num;
	}

}
