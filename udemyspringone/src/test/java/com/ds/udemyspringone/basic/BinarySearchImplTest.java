package com.ds.udemyspringone.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.ds.udemyspringone.UdemySpringBasicApplication;

// Unit testing with spring-test. No need to create object of class here also
// it will inject object, just need to call function and test output
// really easy

// Load the spring application context
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=UdemySpringBasicApplication.class)
class BinarySearchImplTest {
	
	// get bean from application context
	@Autowired
	BinarySearchImp binarySearch;

	@Test
	void testBinarySearch() {
		// call method on binary search
		int result = binarySearch.binarySearch(new int[] {}, 4);
		// check if value is equal
		assertEquals(3, result);
	}


}
