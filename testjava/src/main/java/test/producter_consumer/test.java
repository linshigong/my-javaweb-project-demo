package test.producter_consumer;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 简单通过测试类自身作为锁，实现生产者消费者
 */
public class test {

    public boolean flag = false;

    public String  msg  = "";

    public synchronized void put() {
        if (flag) {
            try {
                wait();
                Thread.sleep(RandomUtils.nextInt(5) * 1000);
            } catch (InterruptedException e) {
                // Ignore
            }
        }
       
        msg = String.valueOf(RandomUtils.nextLong());
        flag = true;
        notifyAll();
    }

    public synchronized void take() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Ignore
            }
        }
        System.out.println("Take msg=" + msg);
        flag = false;
        notifyAll();
    }

    public static void main(String[] args) {

        final test t = new test();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while(true){
                    t.put();
                }
            }
        };
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while(true){
                    t.take();
                }
            }
        };
        
        t1.start();
        t2.start();
    }

}
