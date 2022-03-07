package multithreadin;

public class ThreadDataShare1 {

	/*
	 * Microservice design principle:
	 * https://www.infoq.com/articles/microservices-design-ideals/
	 * 
	 * IDEALS
	 * Interface segreegation : 
	 * Deployability and log, tracing
	 * Event driven 
	 * Availability
	 * Loose coupling
	 * Single responsibility
	 */
	public static void main(String[] args) throws InterruptedException {
		InventoryCounter c = new InventoryCounter();
		IncreamentingThread i = new IncreamentingThread(c);
		DecreamentingThread d = new DecreamentingThread(c);
		i.start();
		d.start();
		i.join();
		d.join();
		
		System.out.println("Number of items we currently have " + c.getItems() );
		// now output should be 0, but its not zero because it have 2 problems
		// 1. InventoryCounter is shared resource, so items is also shared resource
		// 2. so items++ and item-- happening at same time but are not atomic (happening at once / single step)
		
		// synchronized 
		// locking mechanism
		// used to restrict access to a critical section or entire method to a single thread at a time. 
		// it is applied to object - term for that Monitor.
		/*
		 * This is like door, once one thread enters one sync method, 
		 * it will lock entry to another thread for all sync method.
		 * so if thread one is in incraementSync, thread 2 will not be able to access both incraementSync and decrementSync.
		 *  because both method belong to same object. syncronization happens on object level.
		 */
		
		
		// AUtomic operation
		// 1. all reference assignment are atomic, so all getter and setter and automic. (Object a = new Object())
		// 2. all asignment to primitive types are atomic (except long and double). we can read and write to int short without sync.
		// 3. for long and double w can use volatile. volatile double x =20 is thread safe. volatile double y = x;
	}
	
	public static class IncreamentingThread extends Thread {
		
		private InventoryCounter inventory;
		
		public IncreamentingThread(InventoryCounter inventory) {
			this.inventory = inventory;
		}
		
		@Override
		public void run() {
			for (int i=0; i<10000; i++) {
				//inventory.incraement();
				//inventory.incraementSync();
				inventory.incraementSyncBlock();
			}
		}
		
		
	}
	
	public static class DecreamentingThread extends Thread {
		private InventoryCounter inventory;
		
		public DecreamentingThread(InventoryCounter inventory) {
			this.inventory = inventory;
		}
		@Override
		public void run() {
			for (int i=0; i<10000; i++) {
				//inventory.decrement();
				//inventory.decrementSync();
				inventory.decrementSyncBlock();
			}
		}
	}
	
	public static class InventoryCounter {
		private int items =0;
		public void incraement() {
			items++;
			//items = items+1; // same result for this step also. this is not atomic.
		}
		public void decrement() {
			items--;
			//items = items-1;
		}
		public int getItems() {
			return items;
		}
		
		/*
		 * This is like door, once one thread enters one sync method, 
		 * it will lock entry to another thread for all sync method.
		 * so if thread one is in incraementSync, thread 2 will not be able to access both incraementSync and decrementSync.
		 * because both method belong to same object. syncronization happens on object level.
		 * 
		 */
		public synchronized void incraementSync() {
			items++;
		}
		public synchronized void decrementSync() {
			items--;
		}
		public synchronized int getItemsSync() {
			return items;
		}
		
		/*
		 * its working to similar to above. But here we provide object in block
		 */
		Object lock = new Object();
		Object lock2 = new Object();
		public void incraementSyncBlock() {
			synchronized(lock) {
				items++;
			}
		}
		public void decrementSyncBlock() {
			// we can use different object here, so in this way when one thread is in 
			// incraementSyncBlock it will not block another thread to enter this block. this is useful in some cases.
			// (NOT HERE), using following other object to sync will fail the code.
			//synchronized(lock2) { 
			synchronized(lock) { 
				items--;
			}
		}
		public int getItemsSyncBlock() {
			synchronized(lock) {
				return items;
			}
		}
	}

}
