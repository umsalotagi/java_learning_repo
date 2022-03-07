package com.ds.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {
	

	@Test
	void testfindLaegestFromAllData() {
		SomeBusinessImpl bu = new SomeBusinessImpl(new DataServiceStub());
		// we need to create stubDataService as we do not have Data service implementation used in SomeBusinesImp
		int result = bu.findLargestFromAllData();
		assertEquals(67, result);
		
		// DRAWBACK :
		// write ;lot of code to craete stub, need to maintain andd function to stub class
		// need to crate different version of stub class again and again for different set of data to test function with different data source
		// in such cases mockito come in play. reduces need to craete class for serving data
	}

}

// create stub as DataService Impl
// this will act as data source acting as dummmy data
class DataServiceStub implements DataService {

	@Override
	public int[] retriveAllData() {
		return new int[] {10, 11, 12, 67};
	}

	@Override
	public String getData(int dataKey) {
		// TODO Auto-generated method stub
		return "New Data";
	} 
	
}


