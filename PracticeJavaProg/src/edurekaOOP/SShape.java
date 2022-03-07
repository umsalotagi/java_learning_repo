package edurekaOOP;

public interface SShape {
	
	// int numberOfSides;  blank final field : compilation error
	final double PI = 2.17;
	String name = "Shape";
	
	double getArea();  // only public, static etc. allowed
	abstract int getSides();
	
	default void printArea() {
		System.out.println("Printing area " + getArea());
	}
	
	// we cannot override private methods also, not accessible to child methods
	default void defaultMethod() {
		System.out.println("Default Method call");
	}

}
