package com.hashset1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Object;

public class SimpleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Simple one = new Simple(56);
		one.SetTwo("to");
		System.out.println(one);
		// we cannot change value of final variable. 
		// one = new Simple(3); // we cannot change it once assigned
		
		Set<Simple> h = new HashSet<Simple> ();
		Simple a = new Simple(2);
		Simple b = new Simple(2);
		h.add(a);
		h.add(b);
		h.add(new Simple(2));
		System.out.println(a.equals(b) + " " + (a.hashCode()==b.hashCode()) + " "+ b.equals(a));
		System.out.println(h.size()); // output 2
		// this size should be one (as set does not allow duplicate values), but it is two : because  
		// The problem is that your Simple class has not overridden the equals and hashCode methods
		// Any two objects which answer <code>true</code> when passed to  <code>.equals</code> must answer the same value for this method.
		// to store at one location, it gets objects hash value and stored at that location in hashtable
		
		// function is Object class .. that need to be overridden
		
		// HashMap ... 
		// to make HashMap (HadhTable) usable in multi-threading we need to work more on it.
		
		// check polymorphism once more in detail
		
		// Serialization is the conversion of the state of an object into a byte stream; deserialization does the opposite.
		// useful for read and write

		
		PriorityQueue<Simple> sq = new PriorityQueue<Simple>( (o1, o2) -> o1.one-o2.one);
		sq.add(new Simple(4));
		sq.add(new Simple(41));
		sq.add(new Simple(8));
		sq.add(new Simple(5));
		System.out.println(sq);
		// hash is signature not encryption. that goes uniquely without word 
		// encryption is two way
		// hashing is one way. you cant take hash value ahd convert it to data.
		// encyption is method for encoding information, hashing is method for identifyinh information
		
		int[] x = {3, 4, 5, 6, 7};
		OptionalInt xy = Arrays.stream(x).reduce((sum, i) -> sum+i);
		System.out.println(xy);
		Stream<Simple> ok = sq.stream();
		//tpMap function accepts the Function as argument
		Map<Integer, String> pp = ok.collect(Collectors.toMap(Simple::getId, Simple::getName));
		System.out.println(pp);
		/*
		 * The BinaryOperator Interface<T> is a part of the java.util.function package which has been introduced since Java 8, 
		 * to implement functional programming in Java. It represents a binary operator which takes two operands and operates 
		 * on them to produce a result. However, what distinguishes it from a normal BiFunciton is that both of its arguments 
		 * and its return type are same.
		 * 
		 * how java stream internally works
		 * https://theboreddev.com/understanding-java-streams/
		 * it depends on if operation to perform are stateful (distince - remove dup) or stateless (do not need to know other data map, filter). 
		 * we can use parallel stream to run it in multiple threads. easy in stateless operations.
		 */
		
		// Optional 
		// https://www.baeldung.com/java-optional
		
		// https://www.interviewbit.com/spring-interview-questions/
		
		// https://levelup.gitconnected.com/must-know-algorithms-for-coding-interviews-937d807064e0
	}

}
