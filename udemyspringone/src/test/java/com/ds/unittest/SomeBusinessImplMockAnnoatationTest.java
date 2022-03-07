package com.ds.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class SomeBusinessImplMockAnnoatationTest {

	@Test
	void testfindLargestFromAllData() {
		// control+1 for suggestion 
		DataService dataServiceMock = Mockito.mock(DataService.class);
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {10, 23, 45, 88});
		
		// we are using constructor to set DataService object. We can also use setter injection for it
		SomeBusinessImpl sb = new SomeBusinessImpl(dataServiceMock);
		int result = sb.findLargestFromAllData();
		assertEquals(88, result);
	}
	
	@Test
	void testfindLargestFromAllData_ForOneData() {
		// we can create mock of Class also, also Interface
		DataService dataServiceMock = Mockito.mock(DataService.class);
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {0});
		
		SomeBusinessImpl sb = new SomeBusinessImpl(dataServiceMock);
		int result = sb.findLargestFromAllData();
		assertEquals(0, result);
	}
	
	

}
