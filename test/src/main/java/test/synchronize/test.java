package test.synchronize;

/**
 * 静态同步方法执行时，要取到对象锁,下面是程序执行时的jstack输出：
"test2" prio=6 tid=0x01e24c00 nid=0x1784 waiting for monitor entry [0x04aef000..0x04aefae8]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at test.synchronize.test$pojo.subtract(test.java:50)
        - waiting to lock <0x285fd0d0> (a java.lang.Class for test.synchronize.test$pojo)
        at test.synchronize.test$2.run(test.java:24)

"test1" prio=6 tid=0x01df8800 nid=0x14c0 waiting on condition [0x04a5f000..0x04a5fb68]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at test.synchronize.test$pojo.add(test.java:43)
        - locked <0x285fd0d0> (a java.lang.Class for test.synchronize.test$pojo)
        at test.synchronize.test$1.run(test.java:14)
 * 
 * 可以看出，test1线程占用了pojo对象锁(0x285fd0d0)，test2线程在等待这个对象锁。
 * 
 * 结论：静态同步方法需要持有对象锁才能执行，否则会处于阻塞状态。在jdk1.5的版本中，加入了concurrent包,提供了阻塞超时等待等各种并发编程锁的支持。
 *         
 */
public class test {

	public static void main(String[] args) {
		
		Thread t1 = new Thread("test1"){
			@Override
			public void run() {
				while(true){
					pojo.add();
					System.out.println(Thread.currentThread()+"="+pojo.i);
				}
			}
		};
		
		Thread t2 = new Thread("test2"){
			@Override
			public void run() {
				while(true){
					pojo.subtract();
					System.out.println(Thread.currentThread()+"="+pojo.i);
				}
			}
		};
		
		t1.start();
		t2.start();
		
	}
	
	public static class pojo{
		
		static int i = 0;
		
		public static synchronized void add(){
			System.out.println("do add");
			i++;
			try {
				Thread.sleep(1000 * 5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public static synchronized void subtract(){
			System.out.println("do subtract");
			i--;
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
