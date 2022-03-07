package com.interfacebasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainOne {

	public static void main(String[] args) {
		// cannot initialize abstract class directly. can create anonymous class instance
		AbsExtender one = new AbsExtender() {
			
			@Override
			void two() {
				// TODO Auto-generated method stub
				
			}

			@Override
			void one2() {
				// TODO Auto-generated method stub
				
			}
		};
		
		List<Employee> ok = new ArrayList<Employee> ();
		ok.add(new Employee(18, 2000, "z"));
		ok.add(new Employee(30, 5000, "x"));
		ok.add(new Employee(20, 3000, "y"));
		
		// both works
		//ok.sort(null);
		
		//Collections.sort(ok);
		
//		ok.sort(new Comparator<Employee> () {
//			
//			// more like reverse sorting
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				return o2.name.compareTo(o1.name);
//			}
//			
//		});
		//Collections.reverse(ok);
		
		
		// in short lymbda function implements unimplemnted method in functional interface
		ok.sort((x, y) ->  x.salary-y.salary );
		ok.sort((x, y) ->  x.age-y.age );
		
		System.out.println(ok);
		
		xx(() -> { System.out.println("This is good"); return 2; });
		System.out.println(xx( ()-> 500));
		

	}
	
	static class Employee implements Comparable {
		
		int age;
		int salary;
		String name;
		
		public Employee(int age, int salary, String name) {
			this.age = age;
			this.salary = salary;
			this.name = name;
		}
		
		public String toString() {
			return age + "-" + salary + "-"+name;
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(((Employee) o).name);
		}
	}
	
	@FunctionalInterface
	public interface MyInt {
		
		int good();
		
		// interface can't have more than one abstract function
		//boolean ok(int x, int y);
		// but can have any default functino
		
		//public void ok( int x);
		// functional interface can have static methods
		public static int one(int x) {
			return x*x;
		}
		
		// interface can have method body through default functions, and these can be overwritten
		public default int x() {
			return 3;	
		}
		
	}
	
	// if some function accept function interface we can send lymbda function to it.
	public static int xx(MyInt x) {
		return x.good();
	}
	
	
	

}
