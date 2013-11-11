package test.thread;
/**
 * 测试Thread.interrupt方法：
 * 
 * If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods 
 * of the Object class, or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), 
 * methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException. 
 * 
 * PS:如果当前线程，block在Object类的wait(),wait(long)或wait(long,int)方法上，或者block在Thread类的join(),join(long),
 * join(long, int), sleep(long), or sleep(long, int)方法上时，如果调用此线程的interrupt方法，则此线程的interrupt状态会被清除，并收到
 * InterruptedException异常
 * 
 */
public class testInterrupt {
	public static void main(String[] args) {
		Thread t1 = new Thread("Thread.sleep"){
			//方法每隔10s，打印内容，如果被interrupt，则重置interrupt标志
			public void run() {
				while(true){
					System.out.println(Thread.currentThread()+" is running");
					
					try {
						Thread.sleep(1000 * 10);
					} catch (InterruptedException e) {
						//e.printStackTrace();
						System.out.println(Thread.currentThread()+" has been interrupted from sleeping");
					}
					
				}
				
			};
		};
		
		Thread t2 = new Thread("Object.wait"){
			//打印内容后，开始Object.wait，如果被interrupt，则重置interrupt标志
			public void run() {
				while(true){
					System.out.println(Thread.currentThread()+" is running");
					
					try {
						synchronized (this) {//获取当前对象的锁，若为获取对象锁，wait会抛 IllegalMonitorStateException
							this.wait();
						}
					} catch (InterruptedException e) {
						//e.printStackTrace();
						System.out.println(Thread.currentThread()+" has been interrupted from waiting");
					}
					
				}
				
			};
		};
		
		t1.start();
		t2.start();
		
		
		while(true){
			
			try {
				Thread.sleep(1000 * 3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//每隔3s，interrupt t1线程,重置了t1的interrupt状态，这样每隔3s，t1线程就打印一次输出
			//t1.interrupt();
			System.out.println(t1+" state="+t1.getState());
			
			//每隔3s，interrupt or notify t1线程,重置了t1的interrupt状态，这样每隔3s，t2线程就打印一次输出
			//t2.interrupt();
			synchronized(t2){
				//t2.notify();
			}
			System.out.println(t2+" state="+t2.getState());
			
		}
		
		
		
	}
	
}
