package test.producter_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class Consumer implements Runnable{

    private BlockingQueue<String> queue;
    
    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    
    public void consume(){
        String str = null;
        try {
            str = queue.poll(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //Ignore
        }
        System.out.println("C: consume msg=" + str);
    }
    
    @Override
    public void run() {
        while(true){
            consume();
        }
    }
    
}
