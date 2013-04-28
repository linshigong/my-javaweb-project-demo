package test.designpatten.Obsever;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 观察者模式;在此基础上升级，有发布订阅模式，多用于分布式环境（如各种MQ的实现，通过网络传递消息）
 * 
 * 观察者模式: 让主题和观察者之间松耦合
 *  
 */
public class test {

	public static void main(String[] args) {
		
		final MessageProductor productor = new MessageProductor();
		final Subscriber subscriber = new Subscriber();
		productor.addObserver(subscriber);
		
		Thread productorThread = new Thread(){
			public void run() {
				
				while(true){
					int newInt = RandomUtils.nextInt(1000);
					productor.receiveDataAndNotify(String.valueOf(newInt));
					
					try {
						Thread.sleep(3 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			};
		};
		productorThread.start();
		
	}
	
}
