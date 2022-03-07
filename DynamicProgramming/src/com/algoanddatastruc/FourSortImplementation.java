package com.algoanddatastruc;

import java.util.Arrays;

import com.algoanddatastruc.ThreeLinkedList.Node;
import com.algoanddatastruc.ThreeLinkedList.SinglyLinkedList;

public class FourSortImplementation {
	
	public static void main(String[] args) {
		int [] x = mergeSort(new int[] {1, 2, 3, 4, -1});
		//System.out.println(Arrays.toString(x));
		//System.out.println(verifySorted1(new int[] {2, 1, 2, 3, 4}));
		
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.add("Apple");
		ll.add("Cat");
		ll.add("Ball");
		ll.add("Elephant");
		ll.add("Doll");
		System.out.println(ll);
		SinglyLinkedList o = mergeSort(ll);
		System.out.println(o);
		
	}
	
	/**
	 * sorts list in ascending order.
	 * Divide : Find the midpoint of array and divide in sub array
	 * Conquer : recursively sort sublist created by previous list
	 * Combine : merge sorted sub array created in previous step
	 * 
	 * RUNTIME : split operation take time O(k log n). as split operation in python takes O(k). * i dont think it logrithmic runtime
	 * merge operation takes liner time O(n)
	 * overall O(kn log n) 
	 * Space complexity is linear
	 * 
	 * TODO: without using copy of range, use startIndex, endIndex
	 * 
	 * @param array
	 * @return new sorted array
	 */
	public static int[] mergeSort(int[] array) {
		if (array.length<=1) return array; // < is only necessary when empty array is sent as param to sort
		
		// right is reference to base array. so cost is not much
		int[] right = Arrays.copyOfRange(array, array.length/2, array.length);
		int[] left = Arrays.copyOfRange(array, 0, array.length/2);
		
		// this is new list
		int[] sortedRight = mergeSort(right);
		int[] sortedLeft = mergeSort(left);
		
		int[] mergedSort = new int[sortedRight.length + sortedLeft.length];
		
		int i=0, j=0;
		while (true) {
			if (i<sortedRight.length && j < sortedLeft.length) {
				if (sortedRight[i] < sortedLeft[j]) {
					mergedSort[i+j] = sortedRight[i];
					i++;
				} else {
					mergedSort[i+j] = sortedLeft[j];
					j++;
				}
			} else if (i<sortedRight.length) {
				mergedSort[i+j] = sortedRight[i];
				i++;
			} else if (j<sortedLeft.length) {
				mergedSort[i+j] = sortedLeft[j];
				j++;
			} else {
				break;
			}
		}
		return mergedSort;
	}
	
	public static boolean verifySorted1 (int[] sorted) {
		if (sorted.length<=1) return true;
		return ( sorted[0]<sorted[1] && verifySorted1(Arrays.copyOfRange(sorted, 1, sorted.length)));
	}
	
	public static boolean verifySorted (int[] sorted) {	
		for (int i=0; i<sorted.length-1; i++) {
			if (sorted[i] > sorted[i+1]) return false;
		}
		return true;
	}
	
	/**
	 * Recursively divide link list in sublist containing single node
	 * Repeatedly merge sublist to produce sorted sublist
	 * 
	 * @param ll
	 * @return sorted link list
	 */
	public static SinglyLinkedList mergeSort(SinglyLinkedList ll) {
		if (ll==null) return null;
		if (ll.size()<=1) return ll;  // if link list is empty (head is null) or single noded return it directly
		
		// divide Singly link list
		int size = ll.size();
		int mid = size/2;
		Node midNode = ll.nodeAt(mid-1);
		SinglyLinkedList right = ll;
		SinglyLinkedList left = new SinglyLinkedList();
		left.head = midNode.nextNode;
		midNode.nextNode = null;
		
		// recurse
		SinglyLinkedList sortedRight = mergeSort(right);
		SinglyLinkedList sortedLeft = mergeSort(left);
		
		// merge
		Node leftNode = sortedLeft.head;
		Node rightNode = sortedRight.head;
		
		SinglyLinkedList merged = new SinglyLinkedList();
		merged.add("fake"); // adding fake node to list for simplification purpose
		Node current = merged.head;
		
		while (leftNode!=null || rightNode!=null) {
			if (leftNode==null) {
				// right node contains data
				current.nextNode = rightNode;
				rightNode = rightNode.nextNode;
			} else if (rightNode==null) {
				current.nextNode = leftNode;
				leftNode = leftNode.nextNode;
			} else {
				// both are not null
				if (leftNode.data.compareTo(rightNode.data)>0) {
					// left node is bigger
					current.nextNode = rightNode;
					rightNode = rightNode.nextNode;
				} else {
					// left node is equal or smaller
					current.nextNode = leftNode;
					leftNode = leftNode.nextNode;
				}
			}
			current = current.nextNode;
		}
		merged.head = merged.head.nextNode;
		return merged;
	}

}
