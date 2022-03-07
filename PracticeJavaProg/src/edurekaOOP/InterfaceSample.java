package edurekaOOP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edurekaOOP.One.Shape;

public class InterfaceSample {
	
	// creating object inside class, not only  function
	Shape s= new Circle(4);
	
	static {
		int s;
		int sample;
	}
	
	public static void main() {
		// we specify contract in interfaces
		// specifications in system
		// common design pattern
		// you can implement multiple interface but not extend multiple class
		
		System.out.println(Shape.name + Shape.PI + " Its like member of Interface become public static final ");
		// Shape.name = "ok";     not allowed
		
		InterfaceSample o = new InterfaceSample();
		
		// method those are overridden in Circle will get executed. if not overridden, it takes from Shape class
		Shape s = o.new Circle(5);
		System.out.println(s.getArea() + " " + s.getSides() + " " + s.name + " " + s.PI + " " );
		s.defaultMethod();
		s.printArea();
		// s.privateM(2, 5);  this method not available in Shape but only in Circle
		
		
		s = o.new Rectangle(5);
		System.out.println(s.getArea() + " " + s.getSides() + " " + s.name + " " + s.PI + " " );
		s.defaultMethod();
		s.printArea();
		
		Circle c =  o.new Circle(5);
		System.out.println(c.getArea() + " " + c.getSides() + " " + c.name + " " + c.PI + " " );
		c.defaultMethod();
		c.printArea();
		c.privateM(2, 5);
		
		SShape ss = new SShape() {
			
			@Override
			public int getSides() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public double getArea() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		ss.printArea();
		
		
		// Shape s2 = new InterfaceSample().new Shape() // not possible, gives compilation error , illegal enclosing instance specification
		System.out.println("\nmultiple interfaces");
		Triangle t = o.new Triangle(5);
		System.out.println(t.getArea() + " " + t.getSides() + " " + t.name + " " + t.PI + " " );
		t.defaultMethod();
		t.printArea();
		System.out.println(t.figureName());
		
		s = t;
		System.out.println(s.getArea() + " " + s.getSides() + " " + s.name + " " + s.PI + " " );
		// s.figureName();  not accessible
		
		Figure f = o.new Triangle(5);
		System.out.println(f.figureName());
		// f.getArea();  not accessible
		// triangle has taken form of both Shape and Figure. This is was of achieving multiple inheritance in java as java does not allow direct multiple inheritance.
		
		// AweShape is interface extended from Shape and Figure
		AweShapeClass cl = o.new AweShapeClass("irregular");
		System.out.println(cl.getArea() + " " + cl.getSides() + " " + cl.name + " " + cl.PI + " " );
		cl.defaultMethod();
		cl.printName();
		
		s = cl;
		f = cl;
		AweShape aw = cl;
		System.out.println(f.figureName());
		// here as we have seen, cl has taken form of all interfaces it has implemented (AweShape) and also all interfaces, its implemented interfaces (AweShape) has extended (Figure, Shape)
		
		// superclass of all classes is Object class of java
		
		// we does not need to import class to use class of same package. can directly access its members etc.
		// Java has predefined packages : java.lang (Thread, exception, Objects, String , System), java.util,
		// public : accessible to everyone
		// protected : accessible in package and inherited class outside of package
		// default: accessible only in same package
		// private: within same class, even not in inherited class
		
		
		
		// Regular expression
		// pattern used for searching and manipulating String 
		// abbreviation used for regular expression is regex
		// java.util.regex : Pattern , matcher class
		System.out.println("\nRegular Expression Pattern");
		
		String check = "This is Happy";
		Pattern p = Pattern.compile("[a-z]+");
		Matcher m = p.matcher(check);
		while(m.find()) {
			System.out.println(check.substring(m.start(), m.end()));
		}
	}
	
	
	
	interface Shape {
		
		// int numberOfSides;  blank final field : compilation error
		final double PI = 2.17;
		String name = "Shape";
		
		double getArea();  // only public, static etc. allowed
		abstract int getSides();
		
		default void printArea() {
			System.out.println("Printing area " + getArea());
		}
		
		// we cannot override private methods also, not accessible to child methods
		default void defaultMethod() {
			System.out.println("Default Method call");
		}
		
	}
	
	class Circle implements Shape {
		int radius;
		String name1 = "Circle"; // attributes does not get overwritten
		
		Circle (int radius) {
			this.radius = radius;
			System.out.println("In circle : Super name : "+ name + " , here name : " + name1);
		}
		
		@Override
		public double getArea() {  // here only public access modifier need to put. protected, private etc. not allowed as function that we are implementing is public
			// plus we are implementing interface, as API, so this needs to be public. 
			return radius*radius*PI;
		}
		
		@Override
		public int getSides() {
			return 0;
		}
		
		@Override
		public void printArea() {
			System.out.println("Circle Printing area " + getArea());
		}
		
		private int privateM() {
			System.out.println("Private int");
			return 0;
		}
		
		protected int privateM(int x) {
			System.out.println("Private int");
			return 0;
		}
		
		public int privateM(int x, int y) {
			System.out.println("Function only in circle");
			return x+y;
		}
		
		
	}
	
	class Rectangle implements Shape {
		double side;
		Rectangle (double side) {
			this.side = side;
		}
		
		@Override
		public double getArea() {
			return side*side;
		}

		@Override
		public int getSides() {
			
			return 4;
		}
		
	}
	
	
	interface Figure {
		String figureName();
	}
	
	// class extending two interfaces, not possible for abstract or any other class to extend two different classes
	interface AweShape extends Shape , Figure {
		
		void printName();
		
		default void xx() {
			System.out.println("print default in AweShape interface");
		}
	}
	
	// class implementing two interfaces
	class Triangle implements Shape, Figure {
		double side;
		Triangle(double side) {
			this.side = side;
		}
		
		@Override
		public String figureName() {
			return "Tri";
		}

		@Override
		public double getArea() {
			
			return (Math.sqrt(3)/4d)*side*side;
		}

		@Override
		public int getSides() {
			
			return 3;
		}
		
	}
	
	class AweShapeClass implements AweShape {
		String name;
		AweShapeClass(String name) {
			this.name = name;
		}
		
		@Override
		public double getArea() {
			
			return -1;
		}

		@Override
		public int getSides() {
			
			return -1;
		}

		@Override
		public String figureName() {
			return name;
		}

		@Override
		public void printName() {
			System.out.println("Name in Awe " + figureName());
			
		}
		
	}
	
	// abstract class implementing interfaces or extending other abstract need not implement its methods. can be kept blank. 
	abstract class AweShapeClass2 implements AweShape {
		
	}
	
}
