package Practice2;

import java.util.ArrayList;
import java.util.Scanner;

public class MMain {
	
	public static void main(String[] args) {
		int x=0;
		Scanner sc = new Scanner (System.in);
		ArrayList<String> ap = new ArrayList<String>();
		int y = sc.nextInt();
		int y1=1;
		String p="1";
		String p1="1";
	
		
		while (true ) {
		p = p + "0";
			int k = Integer.parseInt(p);
			if (y/k !=0) {
				x++;
	//			p1 = p1 + "0";
				System.out.println("p" + p);
			}
			else
				break;
		}
		
		for (int i =0; i < x; i++) {
			p1 = p1 + "0";
		}
		
		int u;
		int v;
		int k = Integer.parseInt(p1);
		System.out.println(k);

		for (int i =0; i < x+1; i++) {
			
			
			v = y%k;
			try {
				y = y/k;
			}
			catch(Exception e) {
				System.out.println("Done");
			}
			 
			 System.out.println("y" + y);
			 k = k/10;
			 if ( i != x)
				 ap.add("" + v);
			 else
				 ap.add("" + y);
			 
		}
		
		for (String string : ap) {
			System.out.println("doner");
			System.out.print(string);
		}
	}

}
