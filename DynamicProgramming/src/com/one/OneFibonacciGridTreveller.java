package com.one;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class OneFibonacciGridTreveller {
	
	static // time and space complexity of programme
	// time o(n)  space is stack memory (stack space) it will be taking o(n)
	Date date;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		date = new Date();
		//System.out.println(fib(48) ); // 63 857
		System.out.println(" time " + (new Date().getTime()-date.getTime()) );
		
		date = new Date();
		System.out.println(fib2(48) ); // 63 857
		System.out.println(" time " + (new Date().getTime()-date.getTime()) );

		Map<Integer, Integer> mem = new HashMap<Integer, Integer> ();
		
		date = new Date();
		System.out.println(fibRec(48, mem) + " " + mem ); // 63 857
		System.out.println(" time " + (new Date().getTime()-date.getTime()) + " ________");
		
		
		date = new Date();
		System.out.println(gridTraveller(3, 2, "") ); // 63 857
		System.out.println(" time " + (new Date().getTime()-date.getTime()) );
		
		Map<String, Integer> memo = new HashMap<String, Integer> ();
		date = new Date();
		System.out.println(gridTraveller2(12, 12, memo) ); // 63 857
		System.out.println(" time " + (new Date().getTime()-date.getTime()) );
		
		permutation(new int[] {1, 2, 3}, 0);
		
	}
	
	// problem of overlapping subproblem is known as dynamic programming
	public static int fib(int n) {
		if (n<=2) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	// memoization is remembering for repetitive patterns
	// problem where repetitive patterns appear is dynamic programming
	public static int fibRec(int n, Map<Integer, Integer> memo) {
		if (memo.containsKey(n)) return memo.get(n);
		if (n<=2) return 1;
		memo.put(n, fibRec(n-1, memo) + fibRec(n-2, memo));
		return memo.get(n);
	}
	
	public static int fib2(int n) {
		int out=1;
		int prev=0;
		for (int i=1; i<n;i++) {
			int temp =out;
			out = out+prev;
			prev=temp;
		}
		return out;
	}
	
	// o(n) time and space
	public static int foo(int x) {
		if (x<=1) return 1;
		return foo(x-1);
	}
	
	// o(n) time and space
	public static int foo2(int x) {
		if (x<=1) return 1;
		return foo(x-2);
	}
	
	// time complexity o(2^n). no of recursions are 2^n times the input value or level 
	// space complexity of this function is o(n) as each recursion returns value and only then it moves to next recursion
	// exponential time and linear space complexity
	public static int foo3(int x) {
		if (x<=1) return 1;
		foo(x-1);
		foo(x-1);
		return -1;
	}
	
	// so distance will be m+n, binary pattern means one branch giving two. o(2^(m+n)) 
	// time complexity and space complexity (m+n)
	public static int gridTraveller(int m , int n, String previousPath) {
		if (m==1 && n==1) {
			System.out.println(previousPath);
			return 1;
		}
		if (m==0 || n==0) return 0;
		return gridTraveller(m-1, n, previousPath+"Down-") + gridTraveller(m, n-1, previousPath+"Right-");
	}
	
	// m*n distinct nodes - possible combination :  o(m+n) is time complexity
	public static int gridTraveller2(int m , int n, Map<String, Integer> memo) {
		String key = m + "," + n;
		if (memo.containsKey(key)) return memo.get(key);
		if (m==1 && n==1) {
			//System.out.println(previousPath);
			return 1;
		}
		if (m==0 || n==0) return 0;
		memo.put(key,  gridTraveller2(m-1, n, memo) + gridTraveller2(m, n-1, memo));
		return memo.get(key);
	}
	
	// visualize the problem as tree with shrinking size pf problem.
	// large problem, brek down smaller instances of same problem.
	public static void permutation(int[]x, int fixIndex) {
		if (x.length<=fixIndex) return;
		int temp = x[0];
		x[0] = x[fixIndex];
		x[fixIndex] = temp;
		System.out.println(Arrays.toString(x));
		permutation(x, fixIndex+1);
	}
	
	

}
