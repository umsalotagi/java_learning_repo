package multithreadin;

import java.math.BigInteger;

public class ThreadInterrupt3 {
	public static void main(String[] args) {
		LongTask l = new LongTask(new BigInteger("4000000"), new BigInteger("99999999999"));
		
		// Daemon thread runs in background and does prevent application from existing if main thread terminates
		// so, if we do not want to interrupt above thread, but still want to exit application when main thread exit
		//l.setDaemon(true);
				
		l.start(); // application will not close until this thread is finished processing
		l.interrupt(); // even running this interrupt will not actually interrupt the thread.
		// interrupt is signal that many function responds to by throwing InterruptedException. e.g. Thread.sleep()
		
		// THREAD CO_ORDINATION
		// thread.join() // wait for particular thread to complete its activity and join main thread.
		// thread.join(50000) // wait upto maximum 50 seconds or until that given thread to complete before resuming main thread
		
		BigInteger base1 = new BigInteger("4566");
        BigInteger power1= new BigInteger("4566");
        BigInteger base2= new BigInteger("4566"); 
        BigInteger power2= new BigInteger("4566");
		BigInteger result;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
 
        thread1.start();
        thread2.start();
        
        // only put join after starting all the threads, otherwise it will wait only for first thread to 
        // complete and join main thread before starting next thread, in such case we will not have any use of it.
 
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        result = thread1.getResult().add(thread2.getResult());
        System.out.println("This is the result " + result);
	}
	
	private static class LongTask extends Thread {
		
		BigInteger base; 
		BigInteger power;
		
		public LongTask(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}
		
		@Override
		public void run() {
			System.out.println("Calculating power");
			BigInteger out = BigInteger.ONE;
			
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i=i.add(BigInteger.ONE)) {
				// we need to add this line to actually interrupt the thread upong interrupt calling
				if(this.isInterrupted()) {
					System.out.println("Interrupted the calculation .....");
					return;
				}
				out = out.multiply(base);
			}
			
			System.out.println("Got the number "+power+"*"+base+" :" + out);
		}
	}
	
	private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
 
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
 
        @Override
        public void run() {
            result = BigInteger.ONE;
 
            for(BigInteger i = BigInteger.ZERO;
                i.compareTo(power) !=0;
                i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }
 
        public BigInteger getResult() {
            return result;
        }
    }

}
