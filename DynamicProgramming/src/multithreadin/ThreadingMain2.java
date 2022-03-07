package multithreadin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadingMain2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		OneThread o = new OneThread();
		o.setName("Working on..");
		o.setPriority(Thread.MAX_PRIORITY); // ranges from 0-10 , 10 being high
		o.start();
		System.out.println("We are ruuning thread "+Thread.currentThread().getName());
		
		
		Thread t = new Thread(new TwoThread());
		t.start();
		System.out.println("We are ruuning thread "+Thread.currentThread().getName());
		o.sleep(4000); // during this time this thread not consuming any CPU	
		
		// case : how long to guess code by brute force
		// police thread to come back in 10 sec
		Random ran = new Random();
		Vault v = new Vault(ran.nextInt(MAX_LIMIT));
		System.out.println("password is  : "+v.password);
		
		List<Thread> allThreads = new ArrayList<Thread>();
		allThreads.add(new AscendingHackerTread(v));
		allThreads.add(new DescendingHackerThread(v));
		allThreads.add(new PoliceThread());
		
		for (Thread t1 : allThreads) {
			t1.start();
		}
		

		

	}
	
	public static class OneThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("We are in thread "+this.getName() + " and priority : " + this.getPriority());
		}
		
	}
	
	public static class TwoThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static class Vault {
		private int password;
		public Vault(int pass) {
			this.password = pass;
		}
		public boolean isCorrectPassword(int x) {
			try {
				Thread.sleep(5); // sleep current working thread to slow down potential hacker
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return this.password == x;
		}
	}
	
	private static abstract class HackerThread extends Thread {
		protected Vault valut;
		public HackerThread(Vault vault) {
			this.valut = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}
		@Override
		public void start() {
			System.out.println("Running the thread : " + this.getName());
			super.start();
		}
	}
	
	private static int MAX_LIMIT = 9999;
	
	private static class AscendingHackerTread extends HackerThread {
		
		public AscendingHackerTread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for (int guess=0; guess <= MAX_LIMIT; guess++) {
				if (super.valut.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " have guessed the password " + guess);
					System.exit(0);
				}
			}
		}
	}
	
	private static class DescendingHackerThread extends HackerThread {
		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for (int guess=MAX_LIMIT; guess>=0; guess--) {
				if (this.valut.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " have guessed correct name " + guess);
					System.exit(0);
				}
			}
		}
		
	}
	
	private static class PoliceThread extends Thread {
		@Override
		public void run() {
			for (int i=10; i>0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Seconds left to catch hacker " + i);
			}
			System.out.println("Game over for you hacker ");
			System.exit(0);
		}
	}
	


}
