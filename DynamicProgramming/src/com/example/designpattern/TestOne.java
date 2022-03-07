package com.example.designpattern;


import java.util.HashMap;

import com.example.algorithm.BinarySearch;
import com.example.treedatastructure.BinarySearchTree;

public class TestOne {
	
	public static void main(String[] args) {
		TestOne t = new TestOne();
		t.one();
		t.two();
		t.builderDesignTest();
		t.checkTree();
		t.checkTree2();
		t.checkBinarySearch();
		
		//
		String x = "y";
		int y = 2;
		int pp = y==2 && !x.isEmpty() ? 23 : 0;
		System.out.println(pp + " ********** fi");
		System.out.println(x.split(",")[0] + " ********* fi");
		
		HashMap<Integer, String> ok = new HashMap<>();
		ok.put(1, null);
		ok.put(2, "Hi");
		String ha = null;
		int[] k = new int [] {1, 2, 3 };
		for (int i : k) {
			ok.computeIfAbsent(i, (tt) -> ha);
		}
		System.out.println(ok);
	}
	
	
	void one() {
		SingletonOne s =  SingletonOne.getInstance();
		SingletonOne s2 = SingletonOne.getInstance();
		System.out.println(s);
		System.out.println(s2);
		s.printok();
	}
	
	
	void two() {
		SingletonTwo s =  SingletonTwo.getInstance();
		SingletonTwo s2 = SingletonTwo.getInstance();
		System.out.println(s);
		System.out.println(s2);
		s.printok();
	}
	
	
	void builderDesignTest() {
		BuilderDesign design = BuilderDesign.builder().name("one").build();
		System.out.println(design.toString());
		design = BuilderDesign.builder().name("one").salary(4000).build();
		System.out.println(design.toString());
	}
	
	
	void checkTree() {
		System.out.println("in order");
		BinarySearchTree bt = new BinarySearchTree();
		bt.setTreeNode();
		bt.inOrderTraversal();
		System.out.println();
	}
	
	
	void checkTree2() {
		System.out.println("breadth");
		BinarySearchTree bt = new BinarySearchTree();
		bt.setTreeNode();
		bt.breadthTreeTraversal();
		System.out.println();
	}
	
	
	void checkBinarySearch() {
		int[] x = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		BinarySearch b = new BinarySearch();
		//assertEquals(4, b.binarySearch(x, 10));
		System.out.println("search tree");
		System.out.println(b.binarySearch(x, 10));
		System.out.println(b.binarySearch(x, 20));
		System.out.println(b.binarySearch(x, 2));
	}

}
