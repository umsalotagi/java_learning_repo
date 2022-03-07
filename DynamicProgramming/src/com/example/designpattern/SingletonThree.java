package com.example.designpattern;

// Bill Pugh Singleton Implementation
public class SingletonThree {
	
	
	private SingletonThree() {}
	
	private static class SingletonThree1 {
		private static final SingletonThree st = new SingletonThree();
	}
	
	public static SingletonThree getInstance() {
		return SingletonThree1.st;
	}

}
