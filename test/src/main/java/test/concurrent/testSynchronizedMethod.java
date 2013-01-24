package test.concurrent;

/**
 * 1.private static Object lockObject = new Object();
 * 这个锁是静态的，全局锁定；若，不是静态的而是由于实例不同而不同则不能达到锁的目的
 * 
 *
 */
public class testSynchronizedMethod {

	private static Object lockObject = new Object();
	
	public void speak(){
		synchronized (testSynchronizedMethod.lockObject) {
			int time = 10;//second
			System.out.println("--speaking");
			System.out.println("--end speak and sleep for "+time+" second");
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void speak2(){
		int time = 10;//second
		System.out.println("--speaking2");
		System.out.println("--end speak2 and sleep for "+time+" second");
		try {
			Thread.sleep(1000 * 15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void listen(){
		synchronized (testSynchronizedMethod.lockObject) {
			int time = 5;//second
			System.out.println("listening");
			System.out.println("end listen and sleep for "+time+" second");
			try {
				Thread.sleep(1000 * 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void listen2(){
		int time = 5;//second
		System.out.println("listening2");
		System.out.println("end listen2 and sleep for "+time+" second");
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/* LockObject */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					testSynchronizedMethod tsm = new testSynchronizedMethod();
					tsm.speak();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					testSynchronizedMethod tsm = new testSynchronizedMethod();
					tsm.listen();
				}
			}
		});
		
		/* synchronized method */
		final testSynchronizedMethod tsm = new testSynchronizedMethod();
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					tsm.speak2();
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					tsm.listen2();
				}
			}
		});
//		t1.start();
//		t2.start();
		t3.start();
		t4.start();
	}
	
	
}
