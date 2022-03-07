package com.interfacebasics;

public abstract class MyAbstract {
	
	int x = 20;
	int y;
	
	// have constructor to initialize instance variable and non abstract methods
	public MyAbstract(int x) {
		this.y = x;
		
	}
	
	private void one() {
		
	}
	
	public void onePri() {
		
	}
	
	public final void oneFin() {
		
	}
	
	// can have private as well as static method
	private static void two() {}
	
	// public , protected allowed for abstract class
	abstract void one1();
	
	abstract void one2();
	
	final void twoFinal() {
		
	}
	
	

}
