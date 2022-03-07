package com.interfacebasics;

public class One {
	
	public static void main(String[] args) {
		
		System.out.println(2/10);
		System.out.println(fib(20));
		
		Simple s = new Simple();
		// compiler error : method fun is ambiguous for type 
		// s.fun(null);
		s.fun1(null);
		
	}
	
	public static String reverse(String one) {
		StringBuilder sb = new StringBuilder();
		for (int i=one.length()-1; i>=0; i--) {
			sb.append(one.charAt(i));
		}
		return sb.toString();
//		for ( char a : one.toCharArray()) {
//			sb.append(a);
//		}
//		sb.reverse();
	}
	
	public static int fib(int x) {
		int rev=0;
		
		while (x>0) {
			int rem = x%10;
			rev = rev*10 + rem;
			x = x/10;
		}
		return rev;
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
