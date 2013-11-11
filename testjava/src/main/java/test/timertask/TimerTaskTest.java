package test.timertask;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试定时任务执行重叠的情况
 * 
 * 任务是单线程执行，定时任务需要等待前一次任务结束，才会执行下一次
 * 
 * @author wb_shen.chengs
 *
 */
public class TimerTaskTest {

	static{
		TimerTask task = new TimerTask(){
			@Override
			public void run() {
				
				System.out.println(new Date()+"thread is:"+Thread.currentThread()+" output:do job at fixed time");
				try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Timer t = new Timer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//
		t.scheduleAtFixedRate(task, new Date(), 1*1000);// 24*60*60*1000
	}
	
	public static void main(String[] args) {
		new TimerTaskTest();
	}
	
}
