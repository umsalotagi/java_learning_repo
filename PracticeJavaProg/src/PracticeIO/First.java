package PracticeIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First {
	public static void main(String[] args) {
		
		
		int num = 0 ;
		String num1 = null;
		int x=0;
		
		InputStreamReader imp = new InputStreamReader(System.in);
		
		BufferedReader inp = new BufferedReader(imp);
		
//		num1 = imp.getEncoding();
		while (x==0)  {
			System.out.println("give any number");
	
		try {
			num1 = inp.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("might be some error");
		}
		
		try {
			num = Integer.parseInt(num1);
			x++;
		}
		
		catch (Exception e) {
//			e.printStackTrace();
			System.out.println("might be some error");
		}
	}
		
		if (num < 0)
			System.out.println("number is negative " + num);
		else if (num > 0)
			System.out.println("number is positive " + num);
		else 
			System.out.println("number is zero " + num);
		
		
		
		
	}

}
