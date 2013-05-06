package test.threadlocal;


public class test {

	public static ThreadLocal<Object> threadObject = new ThreadLocal<Object>();
	public static ThreadLocal<Object> threadObject2 = new ThreadLocal<Object>();
	
	public static void main(String[] args) {
		test.threadObject.set(new Object());
		test.threadObject2.set(new Object());//ThreadLocalMap对象在线程范围内只有一个实例，以ThreadLocal作为key来set value
		System.out.println(Thread.currentThread().getId()+"="+test.threadObject.get());
		System.out.println(Thread.currentThread().getId()+"="+test.threadObject2.get());
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				test.threadObject.set(new Object());
				System.out.println(Thread.currentThread().getId()+"="+test.threadObject.get());
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				test.threadObject.set(new Object());
				System.out.println(Thread.currentThread().getId()+"="+test.threadObject.get());
			}
		};
		thread1.start();
		thread2.start();
		
		
	}
	
}
