package test.producter_consumer;

import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 对于生产者和消费者都关系一个相同的锁的情况，可以将锁独立出来，
 * 比如使用BlockingQueue，通过queue实例的等待来实现生产和消费的平衡 
 * 
 * 抽象出问题的核心
 *
 */
public class Producter implements Runnable{
    
    private BlockingQueue<String> queue;
    
    public Producter(BlockingQueue<String> queue){
        this.queue = queue;
    }
    
    public void product(){
        String str = String.valueOf(RandomUtils.nextLong());
        try {
            Thread.sleep((RandomUtils.nextInt(3) + 1) * 1000);
            queue.put(str);
        } catch (InterruptedException e) {
            //Ignore
        }
        System.out.println("P: product msg=" + str);
    }
    
    @Override
    public void run() {
        while(true){
            product();
        }
    }
}
