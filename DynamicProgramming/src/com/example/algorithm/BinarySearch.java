package com.example.algorithm;

public class BinarySearch {
	
	public int[] x = {};
	
	// assuming array is pre-sorted
	// returns the index of object
	public int binarySearch(int[] ar, int x) {
		int start = 0;
		int end = ar.length;
		while(start<=end) {
			int mid  = (start+end) / 2;
			if (ar[mid]==x)
				return mid;
			else if (ar[mid]>x) {
				end = mid -1;
			} else {
				start = mid+1;
			}
		}
		return -1;
	}

}
