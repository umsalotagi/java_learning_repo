package com.ds.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyMathTest {
	
	@Test
	public void sumWith3Num() {
		assertEquals(12, new MyMath().sum(new int[] {3,  4, 5}));
	}
	
	@Test
	public void sumWith1Num() {
		assertEquals(3, new MyMath().sum(new int[] {3}));
		
	}
	
	// mockito default mocking fw to test spring boot appplication
	

}
