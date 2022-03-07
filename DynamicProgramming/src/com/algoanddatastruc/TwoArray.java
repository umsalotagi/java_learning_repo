package com.algoanddatastruc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoArray {
	
	public static void main(String[] args) {
		// array is homogenous in java and swift c
		// array memory is contigeous . it occupies contigeous memory. it only sores address of first element.
		// alll other element can be got by index and address of first element.
		
		int[] x = new int[] {1, 2, 3, 4, 5};
		Integer[] xx = new Integer[] {1, 2, 3, 4, 5};
		// all array has basic function. getting, 
		x[0] = 22; // constant runtime
		
		Array.set(x, 1, 49);
		double xdd = 8.9;
		Double p = xdd;
		
		
		System.out.println(Arrays.toString(x) + " ..." + Array.getInt(x, 3) + "..." + Arrays.binarySearch(x, 4));
		List<Integer> ok = new ArrayList<Integer> (Arrays.asList(xx)); // if I use x insetead of xx it gives error as List is not for primitive data types
		System.out.println(Arrays.asList(xx).indexOf(4));
		System.out.println(Arrays.stream(x).boxed().collect(Collectors.toList()).indexOf(4)); // search in array of primitive data type
		
		boolean [] xb = new boolean[] {true, false}; // stream not possible for this
		double[] xd = new double[] {2.3, 6.7, 8.9, 9.0};
		System.out.println(Arrays.stream(xd).boxed().collect(Collectors.toList()).indexOf(2.3));
		//System.out.println(Arrays.stream(xd).map(xp -> Double.valueOf(xp)).collect(supplier, accumulator, combiner));
		
		
		String[] y = new String[] {"7" , "12", "33", "78", "99"};
		Object[] yy =  Arrays.stream(y).map(n -> Integer.parseInt(n)).toArray();
		List<Integer> yi =  Arrays.stream(y).map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(Arrays.toString(yy) + " ............." + yi);
		
		System.out.println("------------------------------ List-----------------");
		yi.add(34); // constant runtine
		yi.set(0, 56); // constant runtime
		yi.add(0, 0); // liner runtime as all the elements are need to be shifted in memory
		
		System.out.println(yi + "..."+ yi.contains(99) + "..." + yi.indexOf(56)+ "..."+ yi.get(3));
		yi.addAll(Arrays.asList(700, 800, 900));
		yi.remove(Integer.valueOf(700)); // remove by element , we can also remove by index. 
		// remove takes linear runtime to perform operation as all the elment need to be shifted to left
		// when accessing the data is more frequent than deleting/inserting, then we can use List, ArrayList
		System.out.println(yi);
		
		// when inserting and deleting data is more frequent than accessign then we need to use LinkedList 
		// each element is contained of node. node also stores the reference of next Node.
		
		LinkedList<String> ll = new LinkedList<String>(Arrays.asList("a",  "b"));
		
	}
	


}
