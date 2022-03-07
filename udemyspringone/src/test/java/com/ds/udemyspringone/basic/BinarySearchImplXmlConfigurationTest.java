package com.ds.udemyspringone.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.ds.udemyspringone.UdemySpringBasicApplication;

// as XML configuration also loaded spring boot beans with using xml, we can use that xml to define test

// Load the spring application context, using xml
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="/applicationContext.xml")
class BinarySearchImplXmlConfigurationTest {
	
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
