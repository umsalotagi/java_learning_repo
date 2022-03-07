package Practice1;

//public class CallByRef2 {
//	
//	public static void main(String[] args) {
//		int p=1, q=2;
//		CallByRef ko = new CallByRef();
//		ko.setValue(p, q);
//		System.out.println("INitial value are");
//		System.out.println(ko.x + " and " + ko.y);
//		ko.setValue(ko);
//		System.out.println(ko.x + " and " + ko.y);
//	}
//
//}


class CallByRef2
{
public static void main(String args[])
{
int x=5,y=10;
CallByRef obj=new CallByRef();
obj.get(x,y); //Pass by Value
System.out.println("Initial Values are-- ");
System.out.println(+obj.n);
System.out.println(+obj.n2);
obj.doubleit(obj); //Pass by Reference
System.out.println("Final Values are");
System.out.println(+obj.n);
System.out.println(+obj.n2);
}
}