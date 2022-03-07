package com.hashset1;

public class Simple {
	
	
	int one;
	String two;
	public Simple(int id) {
		this.one = id;
	}
	public void SetTwo(String two) {
		this.two = two;
	}
	public String toString() {
		return one + " " + two;
	}
	
	public int getId() {
		return one;
	}
	public String getName() {
		return two;
	}
	
	//@Override // no need to annotate with Override for methods overridden from Object superclass
	public boolean equals(Object o1) {
		Simple o = (Simple) o1;
		if (this.one==o.one && this.two==o.two) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return (one + " " + two).hashCode();
	}

}
