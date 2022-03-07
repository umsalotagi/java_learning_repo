package eduraka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

public class FourHours {
	
	public static void main(String[] args) {
		
		// Array Declaration
		String [] ar = new String [5]; // creates null array of 5 length
		// we have memory get reserved when array is declared (int array is 4*5 = 20 bytes reserved)
		String ar2[] = new String [5];
		String [] ar3 = {"we", "are", "good", "here"};
		String ar4[] = new String[] {};
		
		ar4 = ar;
		// string append can append almost all data types
		System.out.println(ar[0] + ar4[2] + 4 + " ok " + true + 5d + 4f + 'c' +  ar3[2]);
		
		int [] [] md = { {2, 4, 6}, {8, 10, 12}};
		System.out.println(md[0].length);
		
		int x = 20;
		System.out.println(x);
		int y = ++x;
		System.out.println(y + " " + x);
		
		char[] ll = new char[] {'K' , 'I', 'L', 'O'};
		System.out.println(new String(ll));
		
		
		String str = new String();
		String str1; // cannot use unless it is initialized
		String str2 = "rr";
		
		// strings are immutable sequence
		// it is thread safe, means synchronization not needed
		System.out.println(str +str2);
		// String stored in string pool of heap area
		// stack memory , heap memory 
		
		// actual object created in heap
		// reference created in stack
		
		System.out.println(str2.concat("This is good"));
		System.out.println(str2);
		System.out.println(String.valueOf(22)); // return string
		System.out.println(str2.replace('r', 'b'));
		System.out.println(str2);
		// contains, equals, startWith, endsWith, 
		
		
		// StringBuffer, synchronous , mutable, we can change its value with append function
		// synchronized : only one thread can use it at one time, which is overhead, 
		// to make faster we need to avoid synchronized , so use StringBuilder for single threaded application.
		
		
		// classes and objects
		// constructor used in creation of an object , used to initialize object, does not have return type
		// constructor is invoked implicitly , method does not
		// default constructor initializes int, String to 0, null
		
		// constructor chaining : call one constructor from another with respect to current object [ e.g. : this("ok") OR super() ] : real purpose , initialization should be done at one place
		// constructor chaining occurs through inheritance
		
		
		
		// Example 1 : reversing the array
		int [] array = {1, 2, 3, 4, 5};
		for (int i=0; i<array.length/2; i++) {
			System.out.println(i);
			int start = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = start;
		}
		for (int x1:array) {
			System.out.println(x1);
		}
		
		// getting addition of first two number as 10
		int [] array2 = {1, 2, 3, 4, 6, 7, 9, 12};
		for (int i=0; i<array2.length; i++) {
			if (i+1>=array2.length){
				break;
			}
			
			if (array2[i]+array2[i+1]==10 ) {
				System.out.println("Got the Add : "+array2[i]+" " +array2[i+1]);
			}
		}
		
		// getting if there is sequence
		int [] array1 = {1, 2, 3, 4, 6, 7, 9, 12};
		for (int i=0; i<array1.length; i++) {
			
			if (i+3>=array1.length){
				break;
			}
			if (array1[i]+1==array1[i+1] && array1[i]+2==array1[i+2]) {
				System.out.println("Got the Sequence : "+array1[i]+" " +array1[i+1]+" " +array1[i+2]);
			}
		}
		
		// print fibonacci
		int second=1;
		int previous=0;
		for (int i=1; i<20; i++) {
			//int previous = i;
			int x1 = second;
			second = second + previous;
			previous = x1;
			
			System.out.println(second);
			
		}
		
		// factorial
		int yy = 0;
		int output = 1;
		for (int i=yy; i>=1; --i) {
			System.out.println(i);
			output = output * i;
		}
		System.out.println("factorial " + output);
		
		// converting
		int [] input = {'a', 'b', 'c', 'a', 'b', 'c', 'd', 'c', 'k', 'b', 'b', 'a', 'a', 'b', 'c'};
		// output should be first occurrence small , capital, small
		
		
		
		
		// https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
		// prime number
		int inputInt = 3;
		Boolean prime = true;
		for (int i=2; i<inputInt; i++) {
			if (inputInt % i == 0) {
				prime = false;
				break;
			}
		}
		
		System.out.println("Prime " + prime);
		
		// String String Palindrome : check if given string is reverse of itself
		String inputString = "oooo";
		Boolean isPalindrome = true;
		for (int i=0; i<inputString.length()/2; i++) {
			if (inputString.charAt(i) != inputString.charAt(inputString.length()-1-i)) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println("isPalindrome " + isPalindrome);
		
		String input22 = "loo";
		
		System.out.println("revers " +reverseString(input22));
		
		// integer Palindrome
		inputInt = 30567;
		int reverse = 0;
		
		while (inputInt != 0) {
			int remainder = inputInt % 10;
			reverse = reverse*10 + remainder;
			inputInt = inputInt / 10;
		}
		
		System.out.println("reverse " + reverse);
		
		
		// Armstrong number
		inputInt = 153;
		int armstrong = 0;
		
		while (inputInt != 0) {
			int remainder = inputInt % 10;
			inputInt = inputInt / 10;
			armstrong = armstrong + remainder * remainder * remainder;
		}
		System.out.println("armstrong " + armstrong);
		
		// remove duplicates from array 
		
		
		
		// find square root
		inputInt = 45;
		
		
		// count repeated characters in string  : ask if needs to be case insensitive or sensitive
		inputString = "thisIsUmesh";
		Map <Character, Integer> ms = new HashMap<>();
		for (char xs: inputString.toCharArray()) {
			Character cx = new Character(xs);
			if (ms.containsKey(cx)) {
				ms.replace(cx, ms.get(cx)+1);
			} else {
				ms.put(cx, 1);
			}
		}
		System.out.println(ms.toString());
		for (Entry<Character, Integer> e : ms.entrySet()) {
			if (e.getValue()==1) {
				System.out.println("Non repedated "+ e.getKey());
			}
		}
//		Boolean b = null;   gives NullPointerException
//		if (b) {
//			System.out.println("fail0");
//		} else {
//			System.out.println("fail");
//		}
		
		printRepeated("thisIsUmesh");
		printNotRepeated("thisIsUmesh");
		
		int[] x5 = {35, 89, -34, 67, 0, 12, 2, 3, 5, 7, 9, 2};
		Arrays.sort(x5);
		int xxx = Arrays.binarySearch(x5, 89); // returns the index of that object, -ve index if element is not in array, need to do sort before it
		System.out.println(Arrays.toString(x5) + xxx);
		
		// binary search and different sort alogorithm (bubble)
		allPermutationsOfString("", "eel");
		
		int[] ppi = {4, 6};
		bubbleSort(ppi);
		
	}
	
	public static String reverseString(String input) {
		if(input == null || input.isEmpty()){
            return input;
        }
		
		return input.charAt(input.length()-1) + reverseString(input.substring(0, input.length()-1));
	}
	
	public static String reverseString2(String in) {
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
	
	
	public static String reverseString3(String in) {
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
	
	
	public static void printRepeated(String input) {
		System.out.println("Input String  :"+ input);
		ArrayList<Character> ac = new ArrayList<>();
		
		for (char x: input.toCharArray()) {
			if (ac.contains(x)) {
				System.out.println("Repeated :" + x);
			} else {
				ac.add(x);
			}
		}
	}
	
	
	public static void printNotRepeated(String input) {
		System.out.println("Input String  :"+ input);
		// ArrayList<Character> ac = new ArrayList<>(input.toCharArray());
		ArrayList <Character> s = new ArrayList <Character>();
		Set <Character> s2 = new HashSet <Character>();  // this needs to be set OR remove will cause index out of bounds exception in ArrayList if it is not contain
		for (char x: input.toCharArray()) {
			if (s.contains(x)) {
				// this is repeated
				s2.remove(x);
			} else {
				s.add(x);
				s2.add(x);
			}
		}
		System.out.println(s2);
	}
	
	// when we do recursive : when we dont know number of for loops we are going to need
	// means when number of for loops we are going to need is dynamic and depends on input, 
	// we need to use recursive function
	public static void allPermutationsOfString(String perDone, String input) {
		
		String input2 = "12";
		for (int i=0; i<input2.length(); i++) {
			System.out.println(  input2.substring(0, i) + " " + input2.substring(i+1, input2.length()));
		}
		//System.out.println("yy" + input.substring(1, 0));
		
		//char[] l = input.toCharArray();
		//char x = input.charAt(0);
		
		//char [] ll = new char[l.length]; 
		if (input.isEmpty())
			System.out.println(perDone);
		for (int i=0; i<input.length(); i++) {			
			//allPermutationsOfString(perDone + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
		}
		
	}
	
	
	public static void allPermutationsOfString2(String perDone, String input) {
		
		if (input.isEmpty())
			System.out.println(perDone);
		for (int i=0; i<input.length(); i++) {			
			allPermutationsOfString(perDone + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
		}
		
	}
	
	public static void bubbleSort(int[] intArray2) {
		
		int [] intArray = {4, 7, 1, -9, 0, 23, 6};
		
		// something wrong in this programme, array changes and same is used
		for (int i =0; i<intArray.length; i++) {
			
			for (int j=0; j<intArray.length; j++) {
				if (intArray[i] > intArray[j]) {
					int temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
					System.out.println(intArray[i] + " "+ intArray[j] + " " + i + " " +j);
				}
				
			}
			System.out.println(i + " " + Arrays.toString(intArray));
		}
		
	}
	
	

}
