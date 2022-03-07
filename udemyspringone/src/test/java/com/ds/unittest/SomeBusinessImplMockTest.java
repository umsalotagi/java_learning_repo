package com.ds.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

// when we use mockeito with annotation then we need to use ExtendWith annotation also
// this is JUnit 5
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl sb;
	
	@Test
	void testfindLargestFromAllData() {
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {10, 23, 45, 88});
		int result = sb.findLargestFromAllData();
		assertEquals(88, result);
	}
	
	@Test
	void testfindLargestFromAllData_ForOneData() {
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {0});
		int result = sb.findLargestFromAllData();
		assertEquals(0, result);
	}
	
	@Test
	void testfindLargestFromAllData_final() {
		Mockito.when(dataServiceMock.retriveAllData()).thenReturn(new int[] {10, 23, 45, 88}).thenReturn(new int[] {0});
		assertEquals(88,  sb.findLargestFromAllData());
		assertEquals(0,  sb.findLargestFromAllData());
	}
	
	@Test
	void testGetDataOfInterface() {
		Mockito.when(dataServiceMock.getData(0)).thenReturn("New Data");
		assertEquals("New Data", dataServiceMock.getData(0));
		assertEquals(null, dataServiceMock.getData(5)); // whenever method called with param different than 0 it returns null
	}
	
	@Test
	void testGetDataAnyParam() {
		Mockito.when(dataServiceMock.getData(Mockito.anyInt())).thenReturn("New Data");
		assertEquals("New Data", dataServiceMock.getData(34));
	}

}
