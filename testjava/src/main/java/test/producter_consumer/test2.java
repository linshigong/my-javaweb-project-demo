package test.producter_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * 通过BlockingQueue实现生产者-消费者模型
 */
public class test2 {

    public static void main(String[] args) {
        
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(3); 
        
        Producter p = new Producter(q);
        Consumer c = new Consumer(q);
        
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(p);
        service.submit(c);
        
    }
    
}
