package com.one;

import java.util.ArrayList;
import java.util.Arrays;

public class FourTabulization {
	
	/*
	 * We used memoization strategy until now to solve dynamic problems
	 * This is intro to tabulation strategy first using fibonacci
	 * 
	 * creating array of size greater than input size by one for for fib(6) , we will create index of length 7 (index 0 to 6)
	 * 
	 * in long run want to fill out this array in a way each sub problem corresponds to one element of this array
	 * seed starting position of this array
	 * 
	 * its fully iterative method
	 * 
	 * Receipe :::::::::::
	 * 1. visualize problem as a table
	 * size and dimention of table : corelated with input
	 * initialize default value. depends on return type. if int then initialize by 0, if bool false
	 * seed the trivial answer in the table 
	 * iterate the table
	 * fill further position based on current position
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(fib(6));
		System.out.println(fib(8));
		
		System.out.println(gridTraveller(3,3));
		System.out.println(gridTraveller(3,2));
		System.out.println(gridTraveller(18,18));
		
		ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		ArrayList<Integer> two = new ArrayList<Integer>(one); // cloning the arraylist
		System.out.println(one + " ..." + two);
		two.add(500);
		System.out.println(one + " ..." + two);
	}
	
	
	public static int fib(int x) {
		int [] table = new int[x+1];
		//Arrays.fill(table, 0);
		table[1] = 1;
		
		for (int i=0; i<=x; i++) {
			//System.out.println(i + " .... " + table[i]);
			try {
				table[i+1] += table[i];
				table[i+2] += table[i];
			} catch (Exception e) {
				
			}
		}
		return table[x];
	}
	
	public static int gridTraveller(int m, int n) {
		int[][] table = new int[m+1][n+1];
		//Arrays.fill(table, 0);
		//System.out.println(Arrays.deepToString(table));
		table[1][1] = 1;
		for (int i=0; i<=m; i++) {
			for (int j=0; j<=n; j++) {
				//System.out.println(Arrays.deepToString(table));
				try {
					table[i][j+1] += table[i][j];
					
				} catch(Exception e) {
					
				}
				if (i+1<=m) table[i+1][j] += table[i][j];
			}
		}
		//System.out.println(Arrays.deepToString(table));
		return table[m][n];
	}
	
	
//	public static bool cansum( int targetSum, int[] x) {
//		
//		
//	}

}
