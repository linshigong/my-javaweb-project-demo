package test.volatiletest;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * long and double need volatile or  proper synchronize to ensure atomic manipulation
 * 
 */
public class testVolatile {

	public static void main(String[] args) {
		
		final pojo p = new pojo();
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				while(true){
				p.setName("jack");
				p.setNum(p.getNum()+1);
				System.out.println(Thread.currentThread()+"="+p.getName()+",num="+p.getNum());
				/**/
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				while(true){
				p.setName("tom");
				p.setNum(p.getNum()+1);
				System.out.println(Thread.currentThread()+"="+p.getName()+",num="+p.getNum());
				
				/**/
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				}
			}
		};
		
		Thread t3 = new Thread(){
			@Override
			public void run() {
				while(true){
				p.setName("lily");
				p.setNum(p.getNum()+1);
				System.out.println(Thread.currentThread()+"="+p.getName()+",num="+p.getNum());
				
				/**/
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				}
			}
		};
		
//		t1.start();
//		t2.start();
//		t3.start();
		BlockingDeque<Runnable> queue = new LinkedBlockingDeque<Runnable>();
		ExecutorService executor = new ThreadPoolExecutor(3,3,1000 * 5,TimeUnit.MILLISECONDS,queue);
		try {
			Future<?> f1 = executor.submit(t1);
			executor.submit(t2);
			executor.submit(t3);
			f1.cancel(true);
			
			executor.awaitTermination(1000 * 20, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long old = p.getNum();
		while(true){
			if(p.getNum() > old){
				old = p.getNum();
				System.out.println(Thread.currentThread()+"="+p.getName()+",num="+p.getNum());
			}
		}
	}

	
	public static class pojo{
		private String name;
		
		volatile long num;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getNum() {
			return num;
		}

		public void setNum(long num) {
			this.num = num;
		}
		
	}
}
