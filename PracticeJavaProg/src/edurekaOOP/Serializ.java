package edurekaOOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edurekaOOP.EnumAndLymbda.Day;

public class Serializ {
	
	public static void main(String[] args) {
		
		// serialization create object into data and store in file, reverse deserialization
		// process of converting object code into byte stream and trasfer the object code from one JVM to another
		// and recreate object by deserialization. We need it for communication, deep copy, Caching, Persistence (Json is new )
		// implementing Serializable, Externizable
		
		
		
		
		
		
		
		System.out.println("re:" + reverseString2(null));
		
		String in = "Happy";
		char[] reverse = in.toCharArray();
		//ArrayList<Character> alc = new ArrayList<>(Arrays.asList(reverse));		
		
		
		// for handling Array we have Arrays class
		// Arrays.asList(a);  Arrays.sort(a);  Arrays.toString(a); Arrays.binarySearch(reverse, 'i')
		Arrays.asList(reverse);
		char[] ok = reverse; // not copied, only reference is changed
		ok[0]='K';
		System.out.println(new String(ok) + " " +new String(reverse)); // similar to arraylist, making changes in ok also made changes in reverse
		System.out.println(Arrays.toString(ok));
		System.out.println(Arrays.binarySearch(reverse, 'p'));
		
		// Because int is a primitive type. Only reference types can be used as generic parameters
		// ArrayList<boolean> alc = new ArrayList<>();
		Integer x = 8;
		ArrayList<Double> alc = new ArrayList<>(Arrays.asList(6.8, 9.0, 4.566));
		System.out.println(alc);
		String red = "255";
		double d = Double.parseDouble(red);
		int d1 = Integer.parseInt(red);
		System.out.println(d + " " + Double.toHexString(d) + " " + Integer.toHexString(d1));
		
		String hexa = "ddffee";
		String n = hexa.replace("ffe", "kkk"); // As string in immutable, this operation will return different new String
		//hexa.re
		System.out.println(hexa + " " + n + " to hexdecimal : " + Integer.parseInt(hexa.substring(0, 2), 16));
		
		
		Day d4 = null;
		switch (d4) {
		case Mon:
			break;
		}
	}
	
	public static String reverseString(String in) {
		if (in==null) {
			return in;
		}		
		
		String reverse = "";
		for(int i=in.length()-1; i>=0; i--) {
			System.out.println(i);
			reverse = reverse + in.charAt(i);
		}
		return reverse;
		
	}
	
	
	public static String reverseString2(String in) {
		if (in==null) {
			return in;
		}		
		
		char[] reverse = in.toCharArray();
		for(int i=0; i<reverse.length/2; i++) {
			char temp = reverse[i];
			reverse[i] = reverse[reverse.length-1-i];
			reverse[reverse.length-1-i] = temp;
		}
		return new String(reverse);
		
	}
	
	public static String sortArray(int[] in) {
		
		for (int i=0; i<in.length; i++) {
			
			for (int j=i+1; j<in.length; j++) {
				if (in[i] < in[j]) {
					
				}
			}
		}
		
		return null;
	}

}
