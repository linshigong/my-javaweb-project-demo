package test.concurrent.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Test CountDownLatch
 * 
 * The first is a start signal that prevents any worker from proceeding until the driver is ready for them to proceed; 
 * The second is a completion signal that allows the driver to wait until all workers have completed. 
 */
class Driver { // ...
	public static void main(String[] args) {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);

		for (int i = 0; i < 10; ++i){
			// create and start threads
			new Thread(new Worker(startSignal, doneSignal)).start();
		}

		doSomethingElse(); // don't let run yet
		
		System.out.println("all workers can work now");
		startSignal.countDown(); // let all threads proceed
		
		doSomethingElse();
		
		try {
			System.out.println("waiting for all workers finished their jobs");
			doneSignal.await();// wait for all to finish
			System.out.println("all done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

	public static void doSomethingElse(){
		System.out.println("doSomethingElse");
	}
	
	static class Worker implements Runnable {
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;

		Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (InterruptedException ex) {
			} // return;
		}

		void doWork() { 
			try {
				Thread.sleep(RandomUtils.nextInt(5) * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("worker is doing work");
			
		}
	}

}
