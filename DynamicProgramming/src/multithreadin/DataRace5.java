package multithreadin;


public class DataRace5 {

	public static void main(String[] args) {
		SharedData shared = new SharedData();
		
		Thread t = new Thread (() -> {
			for (int i=0; i<Integer.MAX_VALUE; i++) {
				shared.increment();
			}
		});
		
		Thread t2 = new Thread (() -> {
			for (int i=0; i<Integer.MAX_VALUE; i++) {
				shared.checkForDataRace();
			}
		});
		
		t.start();
		t2.start();

	}
	
	// Data race : 
	public static class SharedData {
		private volatile int x = 0; // adding volatile afterward
		private volatile int y = 0; // adding volatile afterward
		
		// following sequenece can be reversed for optimizing performance by CPU. as both instrcution are 
		// independ of each other, it is possible that y++ can happen before x++
		// Solution to data race , guarantees of order: 1. synchronized keyword 2. declair shared variable as volatile
		public void increment() {
			x++;
			y++;
		}
		
		public void checkForDataRace() {
			if (y>x) {
				// this should not occur as 
				System.out.println("y>x - Data race detected ....");
			}
		}
	}
	
	// Fine grained locking vs coarse grained locking strategy
	// in coarse grained locking strategy : we make each method synchronized thereby getting one lock for all methods
	// in fine grained, if there are two methods working on independent resources (shared resource), then we can
	// use synchronized(independentObject1) block for locking. 

}
