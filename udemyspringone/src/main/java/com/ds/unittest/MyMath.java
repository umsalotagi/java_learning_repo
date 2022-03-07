package com.ds.unittest;

public class MyMath {
	
	// unit testing is testing of method / group of method 
	// it falls under scope of automation testing. we can do CI
	
	public int sum (int[] num ) {
		int out=0;
		for (int x: num)
			out += x;
		return out;
	}

}
