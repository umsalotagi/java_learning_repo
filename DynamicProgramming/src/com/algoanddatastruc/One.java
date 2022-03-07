package com.algoanddatastruc;

import java.util.Arrays;

public class One {

	public static void main(String[] args) {
		
		// linear search, sequential search
		// algo - algorithmic thinking
		// break the problem in very small problems where each problem can be clearly defined in term of input output
		// clearly defined problem statement, input and output
		// steps in algo need to be in very specific order and steps need to be distinct
		// should produce result and in finite amount of time
		// for given input, output should be consistent.
		
		
		/*
		 *
		https://coderbyte.com/#courses  from dynamic programming from freecodecamp
		
		TreeHouse .. coding platform ... from algo and data strcture from freecodecamp
		
		* 
		algo correctness: it gives same output for same input. and programe terminates with some output.
		efficiency: in term of time and space. memory taken by computer. 
		big o : theoretical definition of complexity of algorithm as a function of size. order of magnitude of complexity . comparing same algorithm. 
		function of size. upper bond of algorithm. how algo performs in worst case scenario.
		
		O(n) big o of n  linear time.
		
		binary search - log of n to the base 2 + 1 : logrithmic runtime. opposite of exponential runtime. O(log n)  O(ln n) : sublinear runtime,
		big o log n - O( log n) -
		
		O(1) : constant time operation  
		
		Quadratic runtime O(n^2) two dimention array . big o of n sqpare
		
		cubic runtime  O(n^3)
		
		Quasilinear runtime O(n * lon n) : merge sort. takes time more than linear runtime. 
		Polynomial runtime O(n^k) or lesser are polynomial. are efficient.
		
		exponential runtime. non efficient' O(x^n)    n is length of input / tries
		
		factorial runtime : travelling salesman : example of exponential runtime 
		
		 */
		
		String st = "ok";
		//System.out.println(st.indexOf("op"));
		
		int[] ar = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int target = 6;
		
		for (int i=0; i<ar.length; i++) {
			if (target==ar[i]) System.out.println(i);
		}
		
		// array has to be sorted before using binary search implementation.
		System.out.println(binarySearchRec(ar, target));
	}
	
	// space complexity O(1) , time complexity O(log n)
	public static int binarySearch (int[] array, int target) {
		
		int first=0, last=array.length-1;
		
		while (first <= last) {
			int mid = (first+last)/2;
			
			if (array[mid]==target) return mid;
			else if (array[mid]<target) first = mid+1;
			else if (array[mid]>target) last = mid-1;
		}
		return -1;
	}
	
	// , time complexity O(log n)
	// tail call optimization is not implemented in python language, thats why recursion is not recommended in python
	// and for this recursion algo, space complexity is space complexity O(log n). lograthmic
	public static boolean binarySearchRec (int[] array, int target) {
		if (array.length==0) return false;
		
		int mid = array.length/2;
		if (array[mid]==target) return true; // returning index will give error and length of array changes of indexes also changes 
		else if (array[mid]<target) return binarySearchRec ( Arrays.copyOfRange(array, mid+1, array.length), target);
		else return binarySearchRec (Arrays.copyOfRange(array, 0, mid), target); 
	}

}
