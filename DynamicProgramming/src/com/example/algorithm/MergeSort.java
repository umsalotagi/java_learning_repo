package com.example.algorithm;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] x = {3, 4, 45, 9, 35};
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(sort(x, 0, x.length-1)));
	}
	
	public static int[] sort(int[] x, int start, int end) {
		
		if(start<end) {
			int mid = start+ (end-start)/2;
			sort(x, start, mid);
			sort(x, mid+1, end);
			
			// merge
			// 0,1
			// Find sizes of two subarrays to be merged
			int n1 = mid - start + 1; 
			int n2 = end - mid;
			int [] l = new int[n1];
			int[] r = new int[n1];
			
			// cpoy data to temp aary
			for (int i=0; i<n1; ++i) {
				l[i] = x[start+i];
			}
			for (int j=0; j<n2; ++j) {
				r[j] = x[mid+j+1]; //
			}
			
			int i=0,j=0;
			// initial index of merged subarray
			int k =start;
			
			while(i<n1 && j<n2) {
				if(l[i]<=r[j]) {
					x[k] = l[i];
					i++;
				} else {
					x[k] = r[j];
					j++;
				}
				k++;
			}
			
			while (i<n1) {
				x[k] = l[i];
				i++;
				k++;
			}
			while (j<n2) {
				x[k] = r[j];
				j++;
				k++;
			}
			return x;
			
		}
		return null;
		
		
	}

}
