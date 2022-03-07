package eduraka;

public final class FinalClass {
	
	private int add;
	
	public FinalClass(int x, int y) {
		add = x+y;
	}
	
	public FinalClass(int x) {
		// constructor chaining, it is calling FinalClass(int x, int y) 
		this(x, 0);
	}
	
	public static int x;
	public static int y2 = 44;
	
	public int y =20;
	protected String str;
	
	public final int multuply(int x, int y) {
		return x*y;
	}
	
	public int add(int x, int y) {
		return x+y;
	}
}
