package com.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AgainTabularization {
	// tabularization
	public static void main(String[] args) {
		
		//System.out.println(fib(6));
		//System.out.println(gridTraveller(12, 12));
//		System.out.println(canSum(7, new int[] {5, 3, 4, 7} ));
//		System.out.println(canSum(7, new int[] {2, 4} ));
//		System.out.println(canSum(8, new int[] {2, 3, 5} ));
//		System.out.println(canSum(300, new int[] {7, 14} ));
		
//		System.out.println(Arrays.toString(howSum(7, new int[] {5, 3, 4, 7} )));
//		System.out.println(Arrays.toString(howSum(7, new int[] {2, 4} )));
//		System.out.println(Arrays.toString(howSum(8, new int[] {2, 3, 5} )));
//		System.out.println(Arrays.toString(howSum(300, new int[] {7, 14} )));
		
//		System.out.println(Arrays.toString(bestSum(7, new int[] {5, 3, 4, 7} )));
//		System.out.println(Arrays.toString(bestSum(7, new int[] {2, 4} )));
//		System.out.println(Arrays.toString(bestSum(8, new int[] {2, 3, 5} )));
//		System.out.println(Arrays.toString(bestSum(100, new int[] {1, 2, 5, 25} )));
		
//		System.out.println(canConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd"})); //t
//		System.out.println(canConstruct("skateboard" , new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); //f
//		System.out.println(canConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"})); //t
//		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" })); //f
//		
		
//		System.out.println(countConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"} ));
//		System.out.println(countConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd"})); 
//		System.out.println(countConstruct("skateboard" , new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); //
//		System.out.println(countConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"})); //
//		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" })); //f
		
		System.out.println(allConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"} ));
		System.out.println(allConstruct("abcdef" , new String[] {"ab", "abc", "cd", "def", "abcd", "ef", "c"} ));
		System.out.println(allConstruct("enterapotentpot" , new String[] {"a", "p", "ent", "enter", "o", "ot", "t"}));
		System.out.println(allConstruct("eeeeeeeeeeeef" , new String[] { "eeee", "eeeee", "eeeeee","eeeeeee" })); //f
		
//		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee","eeeeeee" })); //f
		
		
	}
	
	public static int fib(int x) {
		int[] init = new int[x+1];  // array length is x+1
		init[1] = 1;
		for (int i=0; i<=x; i++) {
			if (i+1<=x)
				init[i+1]+= init[i];
			if (i+2<=x)
				init[i+2]+= init[i];
		}
		System.out.println(Arrays.toString(init));
		return init[x];
	}
	
	public static int gridTraveller(int m, int n) {
		int[][] table = new int[m+1][n+1];
		table[1][1] = 1;
		// use current position to neighbor, as we can travel to right or down we need tp add right and down 
		for (int i=0; i<=m; i++) {  // row
			for (int j=0; j<=n; j++) {
				if (i+1<=m)
					table[i+1][j] += table[i][j];
				if (j+1<=n)
					table[i][j+1] += table[i][j];
			}
		}
		System.out.println(Arrays.deepToString(table));
		return table[m][n];
	}
	
	/* Recipe :::
	 * visualize problem as table. size the table based on input.
	 * initialize table with default value. if returns no, then 0, bool then false.
	 * seed initialize (trivial) answer into the table.
	 * iterate through table.
	 * fill the further based on current position
	 */
	// time comlexity o(m*n) space complexity o(m)   mtargetSum, n=numbers.length
	public static boolean canSum( int targetSum, int[] numbers) {
		// we can use array of elements as many times as we can, all elements are non negative.
		// check what is going to change throughout the problem. or iteration. means dividing problem in smaller problem.
		boolean[] table = new boolean[targetSum+1];
		// targetSum of 0 can be achieved by anything irrespective of any array size
		table[0] = true;
		
		for (int i=0; i<=targetSum; i++) {
			
			if (table[i]) {
				for (int j=0; j<numbers.length; j++) {
					if ( (i+numbers[j]) < table.length)
						table[i+numbers[j]] = true;
				}
			}
			
		}
		//System.out.println(Arrays.toString(table));
		return table[targetSum];
		
	}
	
	public static int[] howSum (int targetSum, int[] numbers) {
		int[][] table = new int[targetSum+1][];
		
		// seeding initial value. trivial. when targetSum is zero, we can achieve it without any elements. so empty.
		table[0] = new int[0];
		
		for (int i=0; i<=targetSum; i++) {
			if (table[i]!=null) {
				for (int j=0; j<numbers.length; j++) {
					
					if (i+numbers[j] < table.length) {
						table[i+numbers[j]] = new int[table[i].length+1];
						//table[i+numbers[j]] = table[i].clone();
						int k=0;
						for (k=0; k<table[i].length ; k++) {
							table[i+numbers[j]][k] = table[i][k];
						}
						table[i+numbers[j]][table[i].length] = numbers[j];
					}
				}
			}
		}
		//System.out.println(Arrays.deepToString(table));
		return table[targetSum];
	}
	
	public static int[] bestSum (int targetSum, int[] numbers) {
		int[][] table = new int[targetSum+1][];
		
		table[0] = new int[0];
		
		for (int i=0; i<=targetSum; i++) {
			
			if (table[i]!=null) {
				
				for (int x : numbers) {
					
					if ( i+x < table.length) {
						if (  table[i+x]==null || table[i].length+1 < table[i+x].length) {
							table[i+x] = new int[table[i].length+1];
							for (int k=0; k<table[i].length; k++) {
								table[i+x][k] = table[i][k];
							}
							table[i+x][table[i].length] = x;
						}
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(table));
		return table[targetSum];
	}
	
	
	public static boolean canConstruct(String target, String[] wordBank) {
		boolean[] table = new boolean[target.length()+1];
		table[0] = true; // it is possible to constrict empty string by given word bank (or any word bank)
		
		//System.out.println(target + "..."+ target.substring(3,5));
		
		for (int i=0; i<target.length(); i++) {
			
			if (table[i]==true) {
				for (String x: wordBank) {
					
					if (i+x.length() <= target.length()) {
						//System.out.println(i + "...." + " ..." + x);
						//System.out.println(i + "...." + target.substring(i, i+x.length()) + " ..." + x);
						if (target.substring(i, i+x.length()).equals(x)) {
							table[i+x.length()] = true;
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(table));
		return table[target.length()];
	}
	
	public static int countConstruct (String target, String[] wordbank) {
		int[] table = new int[target.length()+1];
		// there is one way to create empty string, by concatenating nothing
		table[0] = 1;
		
		for (int i=0; i<target.length(); i++) {
			
			if (table[i]!=0) {
				
				for (String x: wordbank) {
					
					if (i+x.length() <= target.length()) {
						if (target.substring(i, i+x.length()).equals(x)) {
							table[i+x.length()] += table[i];
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(table));
		return table[target.length()];
	}
	
	// exponential complexity in both time and space
	// Processed dump event "systhrow", detail "java/lang/OutOfMemoryError".
	// Exception in thread "main" java.lang.OutOfMemoryError: Java heap space when replayed with last example of eeeeeeeeeeeef
	public static ArrayList<ArrayList<String>> allConstruct (String target, String[] wordBank) {
		ArrayList<ArrayList<ArrayList<String>>> table = new ArrayList<ArrayList<ArrayList<String>>> ();
		for (int i=0; i<=target.length(); i++) {
			table.add(new ArrayList<ArrayList<String>> ());
		}
		
		table.set(0, new ArrayList<ArrayList<String>> (Arrays.asList( new ArrayList<String> () )) );
		
		
		for (int i=0; i<target.length(); i++) {
			
			if (!table.get(i).isEmpty()) {
				
				for (String x: wordBank) {
					
					if (i+x.length() <= target.length()) {
					if (target.substring(i, i+x.length()).equals(x)) {
						//table.set(i+x.length(), element)
						ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>> ();
						for ( ArrayList<String> ok : table.get(i)) {
							//ArrayList<String> k = (ArrayList<String>) ok.clone();
							ArrayList<String> k = new ArrayList<String> (ok);
							k.add(x);
							temp.add(k);
						}
						ArrayList<ArrayList<String>> secondList = new ArrayList<>(table.get(i).stream().map(n ->  {ArrayList<String> tt = new ArrayList<>(n); tt.add(x); return tt; }).collect(Collectors.toList())) ;
						//ArrayList<ArrayList<String>> temp = (ArrayList<ArrayList<String>>) table.get(i).clone();
						//temp.forEach((n) -> n.add(x));
						table.get(i+x.length()).addAll(secondList);
					}
					}
					
				}
			}
		}
		System.out.println(table);
		return table.get(target.length());
	}
	

}
