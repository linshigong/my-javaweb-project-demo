package test.threadlocal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 每个线程都会初始化一次ThreadLocal
 */
public class test2 {

	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				pool p = new pool();
				p.test("hello1");
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				pool p = new pool();
				p.test("hello2");
			}
		};
		
		t1.start();
		t2.start();
		
	}
	
	
	static class pool{
		// avoid recurring construction
		private static ThreadLocal<MessageDigest> MD5 = new ThreadLocal<MessageDigest>() {
			@Override
			protected MessageDigest initialValue() {
				
				System.out.println("create new ThreadLocal object");
				
				try {
					return MessageDigest.getInstance( "MD5" );
				}
				catch ( NoSuchAlgorithmException e ) {
					throw new IllegalStateException( "++++ no md5 algorythm found");			
				}
			}
		};
		
		
		public void test(String value){
			MessageDigest digest = MD5.get();
			digest.update(value.getBytes());//如分为多个部分，循环update即可
			byte[] bKey = digest.digest();//最后调用此方法，表示完毕
			//将上面的128bit字节数组转为自定义的long类型，摘自memcached java client代码
			long res = ((long)(bKey[3]&0xFF) << 24) | ((long)(bKey[2]&0xFF) << 16) | ((long)(bKey[1]&0xFF) << 8) | (long)(bKey[0]&0xFF);
			System.out.println(res);
			
		}
		
	}
	
}
