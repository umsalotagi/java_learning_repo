package com.ds.unittest;

public interface DataService {
	
	// this is external service. getting data from external app. 
	public int[] retriveAllData();
	
	String getData(int dataKey);

}
