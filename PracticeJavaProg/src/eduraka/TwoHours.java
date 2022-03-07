package eduraka;

public class TwoHours {

	// first two hours of https://www.youtube.com/watch?v=hBh_CC5y8-s
	
	// access control
	public Integer publicK = 20;
	private int privateK;
	public int xx;
	protected String protectedStr;
	Boolean defaultBool;
	
	// non-access
	final public static int x = 30;
	public final static String ko = "ko";
	
	final public int add(int x, int y) {
		return x+y;
	}
	
	private int multiply(int x, int y) {
		return x*y;
	}
	
	protected int division(int x, int y) {
		return x/y;
	}
	
	public void setBool(Boolean b) {
		this.defaultBool = b;
	}
	
	public static void staticMethod() {
		System.out.println("Static method in parent");
	}
	
	
	
	public class In extends TwoHours {
		
		// we cannot overwrite add function int shi subclass
		public int add(int x, int y, int z) {
			return x+y+z;
		}
		
		@Override
		public int division(int x, int y) { // this function cannot be private, as we cannot reduce visibility of inherited method
			return x*y*2;
		}
		
		Integer x = 20;
		
		public void smaple() {
			
		}
		
		
		
	}
	
	
	public abstract class abdClass {
		
		public abstract int xx() ;
		
		protected abstract int yy(); // abstract class cannot be private
	}
	
	public final class ok {
		int yy = 20;
	}
	
	
	public class childOfAbstract extends abdClass {

		@Override
		public int xx() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		protected int yy() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		TwoHours t = new TwoHours();
		
		final int x2 = 30;
		
		int y = t.add(x2, 4);
		System.out.println(y);
		
		final TwoHours ftwo = new TwoHours();
		System.out.println(ftwo.defaultBool + " " + ftwo.xx);
		ftwo.setBool(true);
		System.out.println(ftwo.defaultBool);
		
		// here we can create object of abstract class, but at time of creating object we need to implement its unimplemented function
		// anonymous class implementation
		AbstractClass ok = new AbstractClass() {
			
			@Override
			public int multuply(int x, int y) {
				return x*y;
			}
		};
		
		
		System.out.println(ok.multuply(4, 4));
		System.out.println(new SubclassAbstract().multuply(4, 4));
	}
}
