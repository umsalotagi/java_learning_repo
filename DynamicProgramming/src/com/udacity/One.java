package com.udacity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class One {

	public static void main(String[] args) throws IOException {

		int[] array = new int[] {-1, 15, 59, 22, 6, 42, 45, 0};
		int k = 4;
		
		//getLastK(array, k);
		
		// Function and BiFunction are functional interface predefined in java. That can be used as target for lambda expression.
		// Functional interface are interface with only one function declared in it.
		// lambda expression can be saved in Function , BiFunction. 
		// if a function accepts Function or BiFunction it means it accepts lambda expression.
		
		//(x, y) -> x+y;  lambda expression
		Function<Integer, Integer> one = (x) -> x*x;  // takes one param and retuns one value
		BiFunction<Integer, Integer, Integer> two = (x,y) -> x*x+y*y; // takes two param and returns one value
		int total=0;
		Consumer<Integer> three = (x) -> {x += 10;System.out.print(x+" ");}; // takes one param and return no value
		System.out.println(one.apply(5));
		System.out.println(two.apply(5, 2));
		three.accept(400); // doesnot return value
		
		ArrayList<Integer> ok = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 8, 9, 10, 11, 12));
		ok.forEach(three);
		System.out.println(ok);
		// internal for loop, efficient 
		// if function accepts Functional interface, we can send lymbda function as well as method reference
		ok.forEach(System.out::println); // using method reference instead of lambda expression. 
		// check what is Stream and Collectors and telusko channel youtube. method reference.
		
		// https://www.youtube.com/watch?v=9Orn0Pwp3YU
		// new concept in java 8
		ok.stream(); // Stream have two type of methods. Intermediate  filter() sort() map()  Terminate method findFirst() forEach() collect() or reduce()
		// filter has lambda expression which return true or false. map changes value
		// Stream pipeline consist of source , 0 or more intermediete operations and terminate operation. 
		// youtube.com/watch?v=t1-YZ6bF-g0
		// Stream method defined in Collection interface. so available in Array and Set, List, ints, lines of file
		
		System.out.println("--------------------------");
		int red = ok.stream().filter((n) -> (n%2)==0 ).map(x -> x*x).reduce(0, (c, n) -> c+n);
		List<Integer> red2 = ok.stream().filter((n) -> (n%2)==0 ).map(x -> x*x).collect(Collectors.toList());
		System.out.println(red2);
		// following line will not print 4 as filter get executed with terminate method. as there is no terminate method, nothing will syso
		ok.stream().filter((n) -> { System.out.println(n); return (n%2)==0;} );
		ok.stream().filter((n) -> { System.out.println(n); return (n%2)==0;} ).findFirst();  // will print 4 in filer.
		
		Object[] io = ok.stream().filter((n) -> (n%2)==0 ).toArray();
		
		ok.stream().sorted();
		Comparator c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				// - : when o1 is small, + when o1 is big, 0 when both equal.
				// less, equal, greater
				return o1.compareTo(o2);
			}
		};
		// instead of comparator we can use lymbda function .... just wow.
		System.out.println(ok.stream().max((o1, o2) -> o1.compareTo(o2)).get());
		
		// Comparable changes the original class and has compare method to be implemented by class and used as Collections.sort(list_of_o)
		// Comparator does not change any class. its separate obj to be given. Collections.sort(list_of_o, comparator);
		
	}
	
	public static void fileIO () throws IOException {
		
		//IO stream is like endless flow of data connected to data source or data destination. 
		//Stream in java can either be byte stream (readig or writing byte), character stream
		
		// progarmme that needs to read data from data source needs InputStream or Reader
		// ..................... write .......... to destination .. OutputStream or Writer
		// FileInputStream. FileOutputStream .... FileReader, FileWriter . we can use either of one. 
		
		// FileInputStream is used to read byte oriented data such as audio, video, images. 
		// can also be used to read character oriented data, but preffered to use FileReader for this purpose.
		
		File f = new File("D:\\Workspaces\\JavaSpring\\DynamicProgramming\\TempFile.txt");
		//FileInputStream fs = new FileInputStream(f);
		//fs.
		//InputStream abstract class
		FileReader rd = new FileReader(f);
		int r;
		while(( r = rd.read()) != -1 ) {
			System.out.print((char) r);
		}
		rd.close();
		// buffer is region in physical memory (RAM in most cases) used to temporarily store data while its moved from one place to another.
		// for FileIO , bufer is storage which stores data and feedthis to output. 
		BufferedReader br = new BufferedReader(new FileReader(f));
		String one;
		while (( one = br.readLine() ) !=null) {
			System.out.println(one);
		}
		br.close();
		// we can use scanner instead of FileReader to read the file. we can also use Files.readAllLines functions. 
		
		// we can also use Scanner to read from file
		// Scanner can also be used to get input from console.
	}
	
	public static void firstDupChar (String st) {
		
		StringBuilder sb =  new StringBuilder();
		for (int i=0; i<st.length(); i++) {
			char x = st.charAt(i);
			if (sb.toString().contains(Character.toString(x))) {
				System.out.println(i);
				return;
			} else {
				sb.append(x);
			}
		}
		System.out.println(-1);
	}
	
	public static void getLastK( int[] array, int k) {
		Arrays.sort(array);
		System.out.println(Arrays.toString (Arrays.copyOfRange(array, array.length - k, array.length)));;
	}
	
	
	

}
