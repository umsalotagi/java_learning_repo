package com.interfacebasics;

public interface MyInterface1 {
	
	// cannot have constructor
	/*public MyInterface1() {
		
	}*/
	
	final int i = 2;
	
	// possible
	public static void one() {
		return ;
	}
	
	// cannot add final function
	/*public static final void two() {
		return;
	}
	
	protected void three();*/
	
	// abstract method cannot have method body
	abstract void four();
	
	// can have private method without compiler error
	private void k() {
		return;
	}
	
	// can be overridden in implementing class
	default void ko() {
		return;
	}
	
	

}
