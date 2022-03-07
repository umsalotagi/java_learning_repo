package com.one;

public class AllPossibleCombination {
	
	public static void main(String[] args) {
		
		//int[] x = new int[] {, 2, 3};
		//allPossible();
		String x = "abc";
		allPossible(x, 0, x.length()-1);
		
		
	}
	
	public static void allPossible(String x, int fixedIndex, int lastIndex) {
		if (fixedIndex==lastIndex) {
			System.out.println(x);
		} else {
			for (int i=fixedIndex; i<=lastIndex; i++) {
				x = swap(x, fixedIndex, i);
				allPossible(x, fixedIndex+1, lastIndex);
				x = swap(x, fixedIndex, i);
			}
		}
	}
	
	public static String swap(String x, int a, int b) {
		char[] p = x.toCharArray();
		char temp = p[a];
		p[a] = p[b];
		p[b] = temp;
		return String.valueOf(p);
	}

}
