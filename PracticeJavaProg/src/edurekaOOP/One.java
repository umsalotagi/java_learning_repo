package edurekaOOP;

public class One {
	
	public static void main(String[] args) {
		
		// inheritance
		// one object acquires some or all properties and behavior of parent object 
		// inheritance are used for : 1. Method Overriding ( to achieve runtime polymorphism ) 
		// 2. code reusability 
		
		// single inheritance
		// multilevel inheritance
		// Hierarchical inheritance
		
		Calculator cal = new One().new Calculator();
		System.out.println(cal.name + cal.company + cal.add(3, 5) + " " + cal.multiply(3, 5));
		
		// when one task is performed by different ways then it is called polymorphism 
		// here Polymorphism, in which Calculator can take many forms, here Calculator object can only call functions of calculator only, overridden by Sci..
		// function only in sci are not accessible
		// this way is good for abstract classes and interfaces where you have to implement all functions.
		Calculator cal2 = new One().new ScientificCalculator();
		System.out.println(cal2.name + cal2.company + cal2.add(3, 5) + " " + cal2.multiply(3, 5) + " " );  // + cal2.division(3, 5) not accessible also subtract and "SciCal" and "Hi"
		// cannot access cal2.version
		
		// polymorphism is the provision of a single interface to entities of different types or the use of a single symbol to represent multiple different types.
		
		ScientificCalculator cal3 = new One().new ScientificCalculator();
		System.out.println(cal3.name + cal3.company + cal3.add(3, 5) + " " + cal3.multiply(3, 5) + " " + cal3.division(3, 5));
		
		// not possible, cannot convert  (type mismatch)  :: ScientificCalculator cal5 = new One().new Calculator();
		
		System.out.println("\nCircle and Shape example");
		One o = new One();
		
		Circle c = o.new Circle(5);
		System.out.println(c.getArea() + " " + c.getSides() + " " + c.radius + " " + c.numberOfSides);
		
		Rectangle r = o.new Rectangle(4);
		System.out.println(r.getArea() + " " + r.getSides() + " " + r.side + " " + r.numberOfSides);
		
		Shape s = c;
		System.out.println(s.getArea() + " " + s.getSides() + " " +  " " + s.numberOfSides); // s.radius  not accessible any more
		s = r;
		System.out.println(s.getArea() + " " + s.getSides() + " " +  " " + s.numberOfSides); // s.radius  not accessible any more
		
		
		// HAS A Relationship 
		// it means containment, loosely coupled.... Employee had a Name. Name and Employee can be different class ... aggregation 
		
		// static polymorphism
		// method overloading ::: same methods name, return type but different number or data type or arrangement of data type of function
		
		// dynamic polymorphism
		// method overriding :  IS A relationship
		
		// String, System class is final class , constructor cannot be final , blank final variable need to be initialized in constructor 
		
		// dynamic binding , run time polymorphism
		// connecting method call to method body is called binding
		// during run time it decides which method should be called .. again in inheritance 
		// 
		
		// abstraction:
		// mechanism of hiding the implementation details from user and only providing the functionality to the user
		// when you get call, you only know number who is calling , not the operations performed at the backend
		// two ways to achieve abstraction in java
		// abstract class (0 - 100% abstraction)
		// interfaces (100% abstraction)
		
		System.out.println("\nPolymorphism");
		Shape k = o.new Circle (5);  // object of shape is created. first Shape constructor called implicitly inside constructor of circle ... then constructor of circle is executed here
		k.printArea();
		
		// encapsulation : methodology of biding code and data together in to single unit		
		// usually, data is kept private, and not setter method implemented only getter can be implemented. exposing less (chosen) data, method. 
		
		System.out.println("\nInheritance with construcotr");
		Child child = o.new Child("Surname", 4500, "Sonu", 12);
		System.out.println(child.surname + child.name + child.salary + " " + child.standard);
		
		// in following way we can create object of abstract class, by implementing its function
		Shape s1 = o.new Shape() {
			
			@Override
			int getSides() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			double getArea() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		// static : can also be class. specially inner class can also be static, so you does not need to create object of outer class to create object of inner static class
		StaticInnerClass p = new StaticInnerClass();
		NonStaticInnerClass pp = new One().new NonStaticInnerClass();
	}
	
	public int two() {
		return 0;
	} 
	
//	public double two() {  // cannot possible
//		return 0;
//	}
	
	
	
	public double two(int s, String st) {
		return 0.0;
	}
	
	public double two(String st, int s) {
		return 0.0;
	}
	
	
	static class StaticInnerClass {
		StaticInnerClass() {
			System.out.println("Static CLass");
		}
	}
	
	class NonStaticInnerClass {
		NonStaticInnerClass() {
			System.out.println("Static CLass");
		}
	}

	
	class Calculator {
		
		public String name = "Calculator";
		public final String company = "DS";
		
		Calculator() {
			System.out.println("In caculator constructor...");
		}
		
		public int add(int x, int y) {
			final int xy = 22;
			return x+y;
		}
		
		public final int multiply(int x, final int y) {
			return x*y;
		}
		
	};
	
	
	class ScientificCalculator extends Calculator {
		
		//String name = "SciCal";
		// you cannnot override variable, you can just reassign it new value inside constructor or function
		//String company = "Hi";
		String version = "1.1";
		final String sample;
		
		public ScientificCalculator() {
			sample = "ll";
			name = "ScientificCalculator";
			//super.name = "super name";
			System.out.println("In ScientificCalculator " + multiply(2,3));
		}
		
		public double division(int x, int y) {
			return x/y;
		}
		
		@Override
		public int add(int x, int y) {
			// TODO Auto-generated method stub
			return super.add(2*x, y);
		}
		
		public int subtract (int x, int y) {
			return x-y;
		}
	}
	
	abstract class Shape {
		
		Shape() {
			System.out.println("in construcotr of shape... spae object is created");
		}
		
		int numberOfSides;
		int area;
		final double PI = 2.17;
		String name = "Shape";
		
		abstract double getArea();
		abstract int getSides();
		
		void printArea() {
			System.out.println("Printing area " + getArea());
		}
		
		// we cannot override private methods also, not accessible to child methods
		private void privateMethod () {
			System.out.println("Private Method call");
		}
		
	}
	
	class Circle extends Shape {
		int radius;
		String name = "Circle"; // attributes does not get overwritten
		
		Circle (int radius) {
			this.radius = radius;
			System.out.println("In circle : Super name "+ super.name + " here name " + name);
		}
		@Override
		double getArea() {
			// TODO Auto-generated method stub
			return radius*radius*PI;
		}
		@Override
		int getSides() {
			// TODO Auto-generated method stub
			numberOfSides =0;
			return 0;
		}
		
		
		void printArea() {
			System.out.println("Circle Printing area " + getArea());
		}
		
		
	}
	
	class Rectangle extends Shape {
		double side;
		Rectangle (double side) {
			this.side = side;
		}
		@Override
		double getArea() {
			// TODO Auto-generated method stub
			return side*side;
		}

		@Override
		int getSides() {
			// TODO Auto-generated method stub
			numberOfSides = 4;
			return 4;
		}
		
	}
	
	
	class Parent {
		final String surname;
		double salary;
		
		Parent (String surname, double salary) {
			System.out.println("Initalizing Parent class");
			this.surname = surname;
			this.salary = salary;
		}
		
		
	}
	
	class Child extends Parent{
		String name;
		int standard;

		Child(String surname, double salary, String name, int standard) {
			super(surname, salary);  // parent constructor call must be first statement.
			this.name = name;
			this.standard = standard;
			System.out.println("Initialized child class");
			
		}
		
		
	}

}
