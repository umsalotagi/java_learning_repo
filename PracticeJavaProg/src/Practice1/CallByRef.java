package Practice1;

//public class CallByRef {
//	
//	int x;
//	int y;
//	
//	public void setValue (CallByRef temp) {
//		temp.x = 10;
//		temp.y = 20;
//	}
//	
//	public void setValue (int a , int b) {
//		x = a;
//		y = b;
//	}
//
//	
//
//}


class CallByRef
{
int n,n2;
public void get(int a,int b)
{
n=a;
n2=b;
}
public void doubleit(CallByRef temp)
{
temp.n=temp.n*2;
temp.n2=temp.n2*2;
}
}