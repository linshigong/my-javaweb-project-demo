package test.synchronize;

public class test2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread("test1"){
			@Override
			public void run() {
				while(true){
					pojo.one();
				}
			}
		};
		
		Thread t2 = new Thread("test2"){
			@Override
			public void run() {
				while(true){
					pojo.two();
				}
			}
		};
		
		t1.start();
		t2.start();
		
	}
	
	public static class pojo {

		static volatile int i = 0, j = 0;

		static void one() {
			i++;
			j++;
		}

		static void two() {
			System.out.println("i=" + i + " j=" + j);
		}
	}
}
