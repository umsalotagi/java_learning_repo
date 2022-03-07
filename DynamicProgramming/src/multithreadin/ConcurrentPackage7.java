package multithreadin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic Integers & Lock Free E-Commerce
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 * 
 * package java.util.concurrent.atomic contains all Automic class. to perform automic operation on perticular data. wrapper class.
 */

/*
 * Concurrent collections 
 * https://javarevisited.blogspot.com/2013/02/concurrent-collections-from-jdk-56-java-example-tutorial.html#axzz7GPQx3PRq
 * ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet, 
 * BlockingQueue : makes it easy to implement producer-consumer design pattern by providing inbuilt blocking support for the put() and take() method
 */
public class ConcurrentPackage7 {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        private AtomicInteger items = new AtomicInteger(0);

        public void increment() {
            items.incrementAndGet();
        }

        public void decrement() {
            items.decrementAndGet();
        }

        public int getItems() {
            return items.get();
        }
    }
}