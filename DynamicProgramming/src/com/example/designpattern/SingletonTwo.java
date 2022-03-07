package com.example.designpattern;

public class SingletonTwo {
	
	private static SingletonTwo obj;
	
	private SingletonTwo() {}
	
	public static SingletonTwo getInstance() {
		if (obj==null) {
			obj = new SingletonTwo();
		}
		return obj;
	}
	
	public void printok() {
		System.out.println("Get the data");
	}

}
