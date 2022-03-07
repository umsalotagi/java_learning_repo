package eduraka;

public class ChildOfTwoHours extends TwoHours {
	
	// @Override cannot put this, gives compilation error
	public static void staticMethod() {
		System.out.println("Static method in child");
	}
	
	@Override
	public int division(int x, int y) { // this function cannot be private, as we cannot reduce visibility of inherited method
		return x*y*2;
	}
	
	public static void main(String[] args) {
		TwoHours t = new TwoHours();
		t.staticMethod();
		
		TwoHours t1 = new ChildOfTwoHours();
		t1.staticMethod();
		
		ChildOfTwoHours t2 = new ChildOfTwoHours();
		t2.staticMethod();
		
	}
}
