package com.ds.udemyspringone.config;

import java.util.Random;

public class DataClass {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DataClass(String data) {
		super();
		this.data = data + new Random().nextInt();
		System.out.println("Calling the constructor ....." + this.data);
	}
	

}
