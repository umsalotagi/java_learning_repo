package com.interfacebasics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OneComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator<Two> x = (a, b) -> a.salary - b.salary;
		Comparator y = new Comparator<Two> () {
			
			@Override
			public int compare(Two o1, Two o2) {
				// TODO Auto-generated method stub
				// return o1.salary-o2.salary;
				return o1.name.compareTo(o2.name);
			}
		};
		
		ArrayList<String> ok = new ArrayList<> (Arrays.asList("u", "i"));
		for (int i=0; i<ok.size(); i++) {
			ok.set(i, "7"); // does not t
		}
		for (String k : ok) {
			ok.add("t");
		}
		System.out.println(ok);
		
		// fail-fast and fail-safe iterator
		// when iterator realizes, undelying data structure has been modified since iteration has begin
		// adding and removing element is structural modification. updating some value is not structural modification
		// such iterator throw exception
		
		// fail-safe iterator : even you do structural modification it will not throw exception. it works on clone of collection
		// most collection under java.util.concurrent. should be used in multi-threaded application.
		// these are weakly consistent. any modfication while iteration may or may not relfected in collection.`
	}
	
	public static class Two {
		int salary;
		String name;
	}
	

}
