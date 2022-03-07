package edurekaOOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import eduraka.SubclassAbstract.MySingleton;

public class EnumAndLymbda {
	
	// Multi-Threading
	// lymbda function
	// for-each with two variable (for set)
	// Enumeration
	// singleton class
	
	enum PersonProp {
		personID, password, personName, address, emailId, mobileNo, contactNo
	}
	
	public class PersonProp2 {
		
		public static final String personID = "personID"; // Library ID of person e.g. BE10403 , 10403 etc.
		public static final String password = "password"; // password for student account 
		public static final String personName = "personName"; // full Name of person
		public static final String address = "address"; // address of student
		public static final String gUser = "gUser";
		public static final String emailId = "emailId";
		public static final String mobileNo = "mobileNo"; // For notification
		public static final String contactNo = "contactNo";
	}
	
	// function using PersonProp2
	public static void perswonProp2Use(String p) {
		System.out.println(p);
	}
	
	// function using PersonProp
	public static void personPropUse(PersonProp p) {
		System.out.println(p);
	}
	
	enum Day {
		Mon, Tue, Wed, Thu, Fri, Sat, Sun
		// This can have field method and constructor
	}
	
	enum PersonProp3 {
		personID("pesonID"), password("pawd");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		// should not create object, so private
		private PersonProp3(String ok) {
			value = ok;
		}
	}
	
	// function using PersonProp
	public static void dayUse(Day p) {
		switch (p) {
		case Mon:
			System.out.println("Mondayyyyyy");
			break;
		case Tue:
			System.out.println("NOT monday");
		default:
			System.out.println("NOT monday");
			break;
		}
	}
	
	
	public static void main(String[] args) {
		
		// emuns are classses that have fixed set of constants or variable that do not tend to change, enum constant are static and final
		// enum does not support creation of objects, but can implement interface, but cannot be extended
		// it is user defined data type
		// user for switch cases or any other strign input
		System.out.println(PersonProp.emailId);
		System.out.println(PersonProp2.emailId);
		
		perswonProp2Use("Mon");
		perswonProp2Use(PersonProp2.emailId);
		
		personPropUse(PersonProp.emailId);
		dayUse(Day.Thu);
		
		Day [] ar = Day.values();
		for (Day dd: ar) {
			System.out.println(dd + " " + dd.ordinal());
		}
		
		System.out.println("\n\n\n lymbda function");
		// lymbda function
		
		// fundamental of functional programming in java
		// it is function without name and class
		
		// arrow operator ->  divides in two part, parameter and body
		
		// functional interface : when interface have exactly one abstract method
		
		// anonymous class implementation
		Cab cab = new Cab() {
			
			@Override
			public void bookCab() {
				System.out.println("Booked cab, arriving soon !!");
				
			}
		};
		
		// using that implementation
		cab.bookCab();
		
		// lymbda
		Cab cabb = () -> {
			System.out.println("Booked Cab lymbda, arriving soon !!");
		};
		
		cabb.bookCab();
		
		
		// lymbda expression is essentially an object which can be assigned to variable (here cab2) and passed around
		// so its object having single method
		Cab2 cab2 = (arrival, destination) -> {
			System.out.println("Booked cab from " + arrival + " to " + destination);
			System.out.println(Day.Fri + " Access local var");
			return 12;
		};
		
		System.out.println("Arriving in "+ cab2.bookCab("Hinjewadi", "Station"));
		
		
		// lymbda function as method reference
		// TODO :
		
		
		// for each
		Map <String , Integer> mymap = new HashMap<>();
		mymap.put("One", 1);
		mymap.put("two", 2);
		
		ArrayList<String> ars = new ArrayList<>();
		
		mymap.forEach((x, y) -> { System.out.println("Two " + x + y); ars.add(x+y); });
		System.out.println(ars.toString());
		
		BiConsumer<String, Integer> con = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println("Two " + t + u); 
				ars.add(t+u);
				
			}
		};
		
		mymap.forEach(con);
		System.out.println(ars.toString());
		
		// its like for each takes lymbda expression
		// actually for each function takes functional interface. we implement this interface by lymbda expression
		
		
		///////////////////
		// Singleton class in java - here we will initilize the object only once.
		// constructor is private and static method is created to return object
		MySingleton ms = MySingleton.getInstance("DS");
		System.out.println(ms.getCompany());
		ms = MySingleton.getInstance("DS2"); // No new instance cretaed, only old is returned
		System.out.println(ms.getCompany());
	}
	
	@FunctionalInterface
	public interface Cab {
		public void bookCab();
	}
	
	@FunctionalInterface
	public interface Cab2 {
		public double bookCab(String arrival, String destination);
	}
	
	
	

}
