package com.example.designpattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class InterviewTestSingletonBreaking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("k");
		
		String x = "good";
		String rev = "";
		
		for (int i=x.length()-1; i>=0; i--) {
			rev += x.charAt(i);
		}
		System.out.println(rev);
		
		List<String> names = new ArrayList<String> (Arrays.asList("ab", "bc", "cd"));
		names.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		//names.stream().skip(2).forEach(System.out::println); // skips first n elements
		List<String> names2 = names.stream().sorted( (a, b) -> b.compareTo(a) ).collect(Collectors.toList());
		System.out.println("names2 " + names2);
		
		names.sort((p, y) -> y.compareTo(p));
		System.out.println("names with sort and comparator" + names);
		
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		Employee em = new Employee(5, "ok");
		Employee em2 = null;
		try {
			em2 = (Employee) em.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("This is cloned data : "+ em2.empId + em2.name);
		
		SingletonEmp se = SingletonEmp.getInstance();
		System.out.println("This is singleton data : "+ se.empId + se.name);
		SingletonEmp se3 = null;
		try {
			se3 = (SingletonEmp) se.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("This is original data : "+ se);
		System.out.println("This is cloned data : "+ se3);
		
		/*
		 * any abstract class or concrete class ends with reader and writer is character stream. used for reading character data
		 * 
		 * any abstract or concrete class ends with stream is used to read/write byte steam.
		 */
		
		try (ObjectOutput o = new ObjectOutputStream(new FileOutputStream("in.ser"))) {
			o.writeObject(se);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try (ObjectInput b = new ObjectInputStream(new FileInputStream("in.ser"))) {
			SingletonEmp se4 = (SingletonEmp) b.readObject();
			System.out.println("Singleton read object after serilization " + se4);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		 * using java reflection
		 */
		try {
			Constructor[] cons = SingletonEmp.class.getDeclaredConstructors();
			for (Constructor con : cons) {
				con.setAccessible(true);
				SingletonEmp se5 = (SingletonEmp) con.newInstance("name Modified", 3567);
				System.out.println("This is refected object "+se5);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		///
		System.out.println("\n\n\n\n\n888*************$$$$");
		List<String> top = Arrays.asList("studies", "sites", "users");
		
		Map<String, String> ok44 = top.stream().collect(Collectors.toMap(k -> k, v -> { return null; }));
		System.out.println(ok44);
		
		

	}
	
	public static class Apple {
		
		public double m1() {
			return 0;
			// return null // throws compilation error
		}
		
		public int m2() throws IOException {
			
			return 0;
		}
		
		
	}
	
	public static class Ball extends Apple {
		
		@Override
		public int m2() throws Exception {
			return 0;
		}
		
		@Override
		public int m1() {
			return 0;
		}
		
	}
	
	public static class Employee implements Cloneable {
		public int name;
		public String empId;
		
		public Employee(int name, String empId) {
			this.name = name;
			this.empId = empId;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	}
	
	public static class SingletonEmp implements Cloneable, Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8694417277349727218L;
		private String name;
		private int empId;
		
		// we do it as final then we need to define it here only. it will be eager intilization
		private static SingletonEmp INSTANCE;
		// this is lazy initilization
		//private static final SingletonEmp INSTANCE = new SingletonEmp("name", 35);
		
		
		private SingletonEmp(String name, int empId) {
			// this method can be broken by java reflection, to avoid this added following check
			System.out.println("IN private constructor ....");
			if (INSTANCE!=null) {
				throw new RuntimeException("Cought trying java reflection. Cannot create object of singleton class twice.");
			}
			this.name = name;
			this.empId = empId;
		}
		
		public static SingletonEmp getInstance() {
			System.out.println("IN get instance ....");
			//return INSTANCE;
			if (INSTANCE==null) {
				INSTANCE = new SingletonEmp("name", 35);
			}
			return INSTANCE;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			throw new CloneNotSupportedException("Clone not supported for this Singleton instance ...");
		}
		
		// by adding this method, even after deserialization, we get same instance. singleton does not break.
		protected Object readResolve() {
			return INSTANCE; // if we add null here, null be returned after deserialization 
		}
		
	}

}
