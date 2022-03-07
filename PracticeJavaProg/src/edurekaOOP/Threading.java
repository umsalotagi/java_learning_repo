package edurekaOOP;

public class Threading {
	
	// Binary search in array
	// Threading
	// difference between deep copy and sallow copy (both copyies 
	
	// main method represents main thread
	public static void main(String[] args) throws InterruptedException {
		// Thread is lightweight sub process
		// contains separate path of execution
		
		StringBuffer sb = new StringBuffer();
		//StringBuilder sb = new StringBuilder();
		
		Printer p = new Printer();
		
		MyThreadClass tc = new MyThreadClass("**", sb,p);
		MyThreadClass tc2 = new MyThreadClass("&&", sb,p);
		tc2.start();
		// tc2.join();  // for synchronization
		
		// synchronization can be achieved by following ways
		// 1. join function of thread
		// 2. synchronized function
		// 3. synchronized block with object in ()
		
		
		tc.start();
		//Thread.sleep(6000);
		// tc.stop();
		
		
		
		
		// following is not static class
		//MyThreadClass2 mt = new Threading().new MyThreadClass2("##");
		//Thread t = new Thread(mt);
		// t.setDaemon(true);  Daemon thread is not subprocess of main thread but handled by JVM separately. It is started with main method starts
		//t.start();
		
		for (int i=0; i<90; i++) {
			System.out.println("Printing in main Thread .. @@");
		}
		//tc.stop();
		//tc2.stop();
		Thread.sleep(5000);
		System.out.println("String buffer ......");
		System.out.println("String buffer ......" + sb.toString());
		
		// when multiple threads accessing same object, we synchronize it
		
		// java thread pool : manage pool and thread and manage queue
		// inter thread communication - wait and notify as methods 
	}
	
	public static class Printer {
		void printDoc (String doc) {
			for (int i=1; i<=10; i++) {
				System.out.println("Printitng " + doc + i);
			}
		}
		
		synchronized void one() {
			// an option to synchronize block, hwew this function is accessed by one thread at one time
			// acquiring lock on function
		}
	}
	
	
	// MyThreadClass is Thread
	// Thread class is extended only when there is need of overriding other methods of it
	// enable tight coupling
	// thread runs independently , not interfering with main
	public static class MyThreadClass extends Thread {
		
		private String appends;
		private StringBuffer sb;
		private Printer p;
		
		public MyThreadClass(String appends, StringBuffer sb, Printer p) {
			this.appends = appends;
			this.sb = sb;
			this.p = p;
		}
		
		@Override
		public void run() {
			
				synchronized (sb) { // NO other thread can access String buffer sb object until this block gets executed 
					for (int i=0; i<10; i++) {
						System.out.println("Printing here .... " + appends + i);
						sb.append("Printing here .... " + appends + i);
					}
				
				}
				
		}
		
	}
	
	public class Print {
		public void printStatus(String append) {
			for (int i=0; i<10; i++) {
				System.out.println("Printing here .... " + append);
			}
		}
	}
	
	// if class is already extending other class, we cannot have multiple inheritance, so we can implements interface
	// enables loose of coupling
	public class MyThreadClass2 extends Print implements Runnable {
		
		private String appends;
		
		public MyThreadClass2(String appends) {
			this.appends = appends;
		}
		
		@Override
		public void run() {
			printStatus(appends);
			
		}
	}

}
