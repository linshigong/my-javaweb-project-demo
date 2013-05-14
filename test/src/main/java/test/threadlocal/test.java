package test.threadlocal;

/**
每个Thread线程都有个ThreadLocalMap类型的实例变量threadlocals，用来存放与此线程相关的ThreadLocal变量。再来看ThreadLocal保存数据的set方法，代码如下
	public   void  set(T value) {
	Thread t = Thread.currentThread();
	ThreadLocalMap map = getMap(t);
	 if  (map !=  null  )
	    map.set(  this  , value);//以当前threadlocal实例作为key，一个线程可能有多个threadlocal实例以存放不同的变量
	 else
	    createMap(t, value);//当前线程的ThreadLocalMap属性为null，初始化一个并set值
	}
	...
	void createMap(Thread t, T firstValue) {
		t.threadLocals = new ThreadLocalMap(this, firstValue);
	}
	...
首先获取当前的线程t，由getMap方法获取当前线程的threadLocals属性map，然后保存键值对。在保存的时候采用this对象做为键，同样在获取数据的时候，
也是以this作为键来获取相应的数据。因为一个线程可能有多个由ThreadLocal对象保存的变量，采用this作为key，可以实现这样不同ThreadLocal对象之间的区分。
 */
public class test {

	private static final ThreadLocal<Object> threadObject = new ThreadLocal<Object>(){
		@Override
		protected Object initialValue() {
			return "value1";
		}
	};
	private static final ThreadLocal<Object> threadObject2 = new ThreadLocal<Object>();
	
	public static void main(String[] args) {
		
		System.out.println(threadObject.get());//value1
		System.out.println(threadObject2.get());//null
		
		test.threadObject.set(new Object());
		test.threadObject2.set(new Object());//ThreadLocalMap对象在线程范围内只有一个实例，以ThreadLocal作为key来映射value
		System.out.println(Thread.currentThread().getId()+"="+test.threadObject.get());
		System.out.println(Thread.currentThread().getId()+"="+test.threadObject2.get());
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				test.threadObject.set(new Object());
				System.out.println(new ThreadLocal<Object>().get());
				System.out.println(Thread.currentThread().getId()+"="+test.threadObject.get());
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				test.threadObject2.set(new Object());
				System.out.println(Thread.currentThread().getId()+"="+test.threadObject2.get());
			}
		};
		thread1.start();
		thread2.start();
		
		
	}
	
	//for inheritance
	protected void test2(){
		
	}
	
	//friendly,more open than protected
	void test3(){
		
	}
	
	public void test4(){
		
	}
	
	private void test5(){
		
	}
}
