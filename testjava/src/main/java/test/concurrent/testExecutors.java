package test.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class testExecutors {

	public static void main(String[] args) {
		
		int size = 5;
		
		final Map<String, String> map = new ConcurrentHashMap<String, String>();
		
		ExecutorService executorService = Executors.newFixedThreadPool(size);
		
		Future<?> future = executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+" is running");
				try {
					Thread.sleep(1000 * 3);
					map.put("name", "jack");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		try {
			System.out.println(future.get());
			System.out.println(map.get("name"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
		
	}
	
}
