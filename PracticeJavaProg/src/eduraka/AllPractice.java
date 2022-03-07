package eduraka;

public class AllPractice {
	
	public static void main(String[] args) {
	
		
		System.out.println(decimalToOct(8));
		System.out.println(decimalToHexa(18));
		System.out.println(decimalToBinary(8));
		
		onee:
		for (int x=0;x<10;x++) {
			for (int y=0; y<10;y++) {
				if (x==5 && y==7) {
					System.out.println("I am Done !!!" +x + " " + y);
					break onee;
				}
				System.out.println(x + " " + y);
			}
		}
	}
	
	static char deg[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
	
	public static String decimalToOct(int decimal) {
		String out="";
		while (decimal !=0) {
			int top = decimal % 8;
			decimal = decimal / 8;
			out =deg[top] + out;
			System.out.println(decimal + " " + top);
		}
		return out;
		
	}
	

	
	static char deg2[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static String decimalToHexa(int decimal) {
		String out="";
		while (decimal !=0) {
			int top = decimal % 16;
			decimal = decimal / 16;
			out = deg2[top] + out;
			System.out.println(decimal + " " + top);
		}
		return out;
		
	}
	
	static char deg3[] = {'0', '1'};
	
	public static String decimalToBinary(int decimal) {
		String out="";
		while (decimal !=0) {
			int top = decimal % 2;
			decimal = decimal / 2;
			out = deg2[top] + out;
			System.out.println(decimal + " " + top);
		}
		return out;
		
	}
	
	
}
