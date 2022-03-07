package multithreadin;

public class OneThread implements Runnable{
	
	int x = 7;
	
	public static void main(String[] args) {
		OneThread o = new OneThread();
		Thread t = new Thread(o);
		t.start();
		for (int i=0; i<5; i++) {
			System.out.println(o.x);
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.x = 8;
		
	}

}
