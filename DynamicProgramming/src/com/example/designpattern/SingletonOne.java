package com.example.designpattern;

public class SingletonOne {
	
	private static final SingletonOne obj = new SingletonOne();
	
	private SingletonOne() {}
	
	public static SingletonOne getInstance() {
		return obj;
	}
	
	public void printok() {
		System.out.println("Get the data");
	}

}
