package com.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoCanSumHowSumBestSum {
	
	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] {2, 4} , ""));
		//System.out.println(canSum(300, new int[] {7, 14} , ""));
		
		Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
		
		System.out.println(canSum(7, new int[] {5, 3, 4, 7} , memo));
		System.out.println(canSum(300, new int[] {7, 14} , memo));
		
		Map<Integer, ArrayList<Integer>> memo2 = new HashMap<Integer, ArrayList<Integer>>();
		
		System.out.println(howSum(7, new int[] {5, 3, 4, 7} , memo2));
		memo2.clear();
		System.out.println(howSum(300, new int[] {7, 14} , memo2));
		memo2.clear();
		System.out.println(howSum(8, new int[] {1, 4, 5}, memo2));
		memo2.clear();
		System.out.println(howSum(100, new int[] {1, 2, 5, 25}, memo2).size());
		
		
//		System.out.println(permutation(new int[] {1, 2, 3}, 0));
//		
//		System.out.println(bestSum(7, new int[] {5, 3, 4, 7}));
//		System.out.println(bestSum(8, new int[] {1, 4, 5}));
//		
		memo2.clear();
//		System.out.println(bestSumMemo(100, new int[] {1, 2, 5, 25}, memo2));
//		
	}
	
	// m is x (targetsum) , n is list.size()
	// time complexity o(m^n)    and space complexity o(m)
	// instead of sending array and adding them to it , its better to make function return it
	public static boolean canSum(int x , int [] list , String prev) {
		if (x==0) {
			System.out.println(prev);
			return true;
		}
		//if (x<0) return false;
		for (int i : list) {
			int y = x - i;
			if (y>=0) {
				if (canSum(y, list, prev+","+i))
					return true;
				
			}
			
		}
		return false;
	}
	
	// time complexity o(m*n) and space complexity o(m)
	public static boolean canSum(int x , int [] list , Map<Integer, Boolean> memo ) {
		if (memo.containsKey(x)) return memo.get(x);
		if (x==0) {
			//System.out.println(prev);
			return true;
		}
		//if (x<0) return false;
		for (int i : list) {
			int y = x - i;
			if (y>=0) {
				if (canSum(y, list, memo)) {
					memo.put(x, true);
					return true;
				}	
			}
		}
		memo.put(x, false);
		return false;
	}
	
	// m is x , n is list.size()
	// brute force  : time complexity o(n^m * m)  , space complexity o(m)    
	// memoised solution : time complexity o(n*m^2) , space complexity o(m^2)
	public static ArrayList<Integer> howSum(int x , int [] list , Map<Integer, ArrayList<Integer>> memo ) {
		if (memo.containsKey(x)) {
			return memo.get(x);
		}
		if (x==0) {
			//System.out.println(prev);
			return new ArrayList<Integer>();
		}
		//if (x<0) return false;
		for (int i : list) {
			int y = x - i;
			if (y>=0) {
				ArrayList<Integer> ok = howSum(y, list, memo);
				if (ok!=null) {
					ok.add(i);
					memo.put(x, ok);
					return ok;
				}	
			}
		}
		memo.put(x, null);
		//System.out.println(memo);
		return null;
	}
	
	public static int permutation(int[] one, int currentIndex) {
		
		if (one.length==currentIndex+1) {
			System.out.println(Arrays.toString(one));
			return 1;
		}
		int out = 0;
		for (int i =currentIndex; i<one.length; i++) {
			int temp = one[currentIndex];
			one[currentIndex] = one[i];
			one[i] = temp;
			
			out = out + permutation(one, currentIndex+1);
			
			temp = one[currentIndex];
			one[currentIndex] = one[i];
			one[i] = temp;
		}
		return out;
	}
	
	// m targetSum, n numbers.length
	// without memo : Brute Force : time complexity : branching factor to the height power
	// length of array is brnaching factor. and targetSum is height
	// time complexity o(n^m)
	// space complexity : o(m*n) = o(m^2)
	public static ArrayList<Integer> bestSum(int targetSum, int [] numbers) {
		if (targetSum==0) return new ArrayList <Integer>();
		//if (targetSum<0) return null;
		
		ArrayList<Integer> shortestCombination = null;
		for (int i =0; i<numbers.length; i++) {
			int remainder = targetSum - numbers[i];
			if (remainder>=0) {
				ArrayList<Integer> combination = bestSum(remainder, numbers);
				if (combination != null) {
					combination.add(numbers[i]);
					if (shortestCombination==null || shortestCombination.size() > combination.size()) {
						shortestCombination = combination;
					}
				}
			}
		}
		return shortestCombination;
	}
	
	// time complexity : o(m*n*m)
	// space complexity o(m^2)
	public static ArrayList<Integer> bestSumMemo(int targetSum, int [] numbers, Map<Integer, ArrayList<Integer>> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		if (targetSum==0) return new ArrayList <Integer>();
		//if (targetSum<0) return null;
		
		ArrayList<Integer> shortestCombination = null;
		for (int i =0; i<numbers.length; i++) {
			int remainder = targetSum - numbers[i];
			if (remainder>=0) {
				// this cloning is necessary as we might return reference to ArrayList from that memo
				// and make changes to memo by making changes to thi arraylist. so we need new list, not old one.
				ArrayList<Integer> combination = (ArrayList<Integer>) bestSumMemo(remainder, numbers, memo).clone();
				if (combination != null) {
					combination.add(numbers[i]);
					if (shortestCombination==null || shortestCombination.size() > combination.size()) {
						shortestCombination = combination;
					}
				}
			}
		}
		memo.put(targetSum, shortestCombination);
		return shortestCombination;
	}

}
