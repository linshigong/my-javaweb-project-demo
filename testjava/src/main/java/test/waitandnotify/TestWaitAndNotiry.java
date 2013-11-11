package test.waitandnotify;

/**
 * Test: Wait & Notify & Interrupt
 */
public class TestWaitAndNotiry {
	
	public static void main(String[] args) {
		
		final Object obj = new Object();
		
		final Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					for(;;){
						synchronized (obj) {
							System.out.println("thead "+Thread.currentThread().getName()+"is wating...");
							obj.wait();	
						}
					}
				} catch (InterruptedException e) {
					System.out.println("thead "+Thread.currentThread().getName()+"has been interrupted");
				}
			}
		};
		
		/**/
		Thread t2 = new Thread(){
			@Override
			public void run() {
				
				try {
					for(;;){
						Thread.sleep(2 * 1000);
						synchronized (obj) {
							if(!t1.isAlive()){
								break;
							}
							System.out.println("thead "+t1.getName()+"has been notified");
							obj.notify();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		/**/
		Thread t3 = new Thread(){
			@Override
			public void run() {
				
				try {
					Thread.sleep(8 * 1000);
					if(t1.isAlive()){
						System.out.println("inerrupting thread="+t1.getName());
						t1.interrupt();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
