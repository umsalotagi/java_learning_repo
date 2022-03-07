package com.ds.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeBusinessImpl {
	
	@Autowired
	private DataService dataService;
	// this data service we do not have, we do not have implementation of this data service.
	// then how we are going to test this function, as we do not have any implementation of dataService
	// so in this case we can use mockito to mock dataService external
	
	// we need to add constructor for initializing the stub data source class, which accept data service for creating SoeBusinessImpl
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	int findLargestFromAllData() {
		int[] one = dataService.retriveAllData();
		int out = Integer.MIN_VALUE;
		for (int i : one) {
			if (i>out)
				out = i;
		}
		return out;
	}

	
	
}
