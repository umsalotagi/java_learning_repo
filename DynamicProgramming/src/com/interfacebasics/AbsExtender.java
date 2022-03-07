package com.interfacebasics;

public abstract class AbsExtender extends MyAbstract{
	
	public AbsExtender() {
		super(2);
	}

	@Override
	void one1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onePri() {
		
	}
	
	//cannot override final method
	
	
	
	abstract void two();


}
