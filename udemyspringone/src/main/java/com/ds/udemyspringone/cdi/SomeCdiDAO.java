package com.ds.udemyspringone.cdi;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class SomeCdiDAO {
	
	public SomeCdiDAO() {
		System.out.println("SomeCdiDAO created");
	}
	
	// typically this data comes from database
	public int[] getData() {
		return new int[] {5, 89, 70};
	}

}
