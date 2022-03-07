package multithreadin;

import java.util.Random;

public class ThreadVolatile4 {
	
	public static void main(String[] args) {
		Metrics m = new Metrics();
		
		BusinessLogic b = new BusinessLogic(m);
		BusinessLogic b2 = new BusinessLogic(m);
		MetricsPrinter p = new MetricsPrinter(m);
		
		/*b.start();
		b2.start();
		p.start();*/
		
		
	}
	
	public static class MetricsPrinter extends Thread {
		private Metrics metrics;
		
		public MetricsPrinter(Metrics metrics) {
			this.metrics = metrics;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double currentAvg = metrics.getAvg();
				System.out.println("Currrent Avg, : "+ currentAvg);
			}
		}
		
	}
	
	public static class BusinessLogic extends Thread {
		private Metrics metrics;
		private Random ran = new Random();
		
		public BusinessLogic(Metrics metrics) {
			this.metrics = metrics;
		}
		
		@Override
		public void run() {
			while(true) {
				long start = System.currentTimeMillis();
				
				// this is our business logic
				try {
					Thread.sleep(ran.nextInt(10));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				long end  = System.currentTimeMillis();
				metrics.addSample(end-start);
			}
		}
	}
	
	// shared among different threads
	public static class Metrics {
		private long count = 0;
		// assignments to primitive is atomic (except double and long, so read and write will not be atomic)
		private volatile double avg = 0.0; // so ensures getter and st at addSample are both automic.
		
		// this is not atomic, so need to protect this method from concurrent execution
		// solving race condition. where multimple thread share same data and at least one try to modify it.
		public synchronized void addSample(long sample) {
			double currentSum = count*avg;
			count++;
			avg = (currentSum+sample)/count;
		}
		
		// assingment and read of reference and primitive is automatic, non need to sync
		public double getAvg() {
			return avg;
		}
	}
	
	

}
