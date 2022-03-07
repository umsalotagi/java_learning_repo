package edurekaOOP;

public class ExceptionCl {
	
	public static void main(String[] args) {
		
		// checked exception: compile time exception : need to handle by try catch block
		// unchecked exception : run time exception 
		// Error: stackoverflow (call million time), ThreadDeath
		
		Exception e = new ArithmeticException();
		
		int x = 5;
		try {
			exp(x);
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			x = 2;
		} finally {
			// release resources, release socket connection, database connection 
		}
		
		Throwable t = new Throwable("Ok");
		// Exception class and Error and subclasses of Throwable
		// RuntimeException is subclass of Exception
		// IOException is subclass of exception
		
		
	}
	
	
	// throws keyword is used in method signature
	public static int exp(int x) throws MyException {
		
		if (x<5) {
			// throw is used in within method
			throw new ExceptionCl().new MyException();
		}
		else if (x>10) {
			throw new ExceptionCl().new MyRunException();
		} else {
			throw new ExceptionCl().new MyError();
		}
	}
	
	
	class MyException extends Exception {
		// IOException, SQLException
	}
	
	class MyRunException extends RuntimeException {
		// NullPointerException, ArithmeticException (/ by zero), IndexOutOfBoundsException 
	}
	
	
	class MyError extends Error {
		// An Error is a subclass of Throwable that indicates serious problems that a reasonable application 
		// should not try to catch. Most such errors are abnormal conditions.The ThreadDeath error, 
		// though a "normal" condition,is also a subclass of Error because most applications should not try to catch it. 
		
		// That is, Error and its subclasses are regarded as unchecked exceptions for the purposes of compile-time checking of exceptions.
	}

}
