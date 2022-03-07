package multithreadin;

import java.util.Set;



public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// thread.start : this will instruct JVM to create new thread and pass it to OS.
		
		// Singleton with ENUM
		One a = One.INSTANCE;
		System.out.println(a.getSum());
		
		Set.of(); // immutable unmodifiable set java 9
		//Collections.unmodifiableSet(null)
		
		Simple s = new Simple();
		// compiler error : method fun is ambiguous for type 
		// s.fun(null);
		s.fun1(null);  // String function will be called, as it is most specific function. Object will be more generic function.

	}
	
	public static enum One {
		INSTANCE(2, "Done", 4.5);
		
		private final int a;
		private final String b;
		private final double c;
		
		/*
		 * enum can contain a constructor and it is executed separately for each enum constant at the time of 
		 * enum class loading. We can't create enum objects explicitly and hence we can't invoke enum constructor directly.
		 * check enum Permission
		 */
		private One(int a, String b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public String getSum() {
			return a + b + c;
		}
		
	}
	
	public static class Simple {
		// Compiler exception : recursive invocation exception : compiler error
		// Compiler error : constructor call must be first statement in constructor 
		public Simple() {
			super();
			//this();
			System.out.println("This is good question...");
		}
		
		public void fun(String a) {
			System.out.println("This is String function "+a);
		}
		
		public void fun(Integer a) {
			System.out.println("This is Integer function "+a);
		}
		
		public void fun1(String a) {
			System.out.println("This is String function "+a);
		}
		
		public void fun1(Object a) {
			System.out.println("This is Object function "+a);
		}
	}
	

}
