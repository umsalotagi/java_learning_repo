package multithreadin;


import java.util.Random;

/**
 * Locking Strategies & Deadlocks
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 * 
 * with fine grained locking we can come across deadlock situation
 * 
 * Condition for deadlock : 
 * 4. circular wait - circular dependency
 * 
 * How to avoid deadlock :
 * 1. Enforcing strict order on lock acquisition prevents deadlock. (good for small no. of locks)
 * 2. Deadlock detection - watchdog. routine checks status of register which is updated by different thread. non-response thread are re-started
 * 3. Thread interrupt (not possible with synchronized)
 * 4. tryLock operation (not possible with synchronized)
 */

/*
 * Advanced locking : re-entrant lock . explicit lock and unlock.
 */

/*
 * read/assignment on all volatile primitive types and references
 */
public class Deadlock6 {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();
    }

    public static class TrainB implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch (InterruptedException e) {
                }

                intersection.takeRoadB();
            }
        }
    }

    public static class TrainA implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }

        @Override
        public void run() {
            while (true) {
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                } catch (InterruptedException e) {
                }

                intersection.takeRoadA();
            }
        }
    }

    public static class Intersection {
        private Object roadA = new Object();
        private Object roadB = new Object();

        public void takeRoadA() {
            synchronized (roadA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

                synchronized (roadB) {
                    System.out.println("Train is passing through road A");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        public void takeRoadB() {
            synchronized (roadB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread().getName());

                synchronized (roadA) {
                    System.out.println("Train is passing through road B");

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
