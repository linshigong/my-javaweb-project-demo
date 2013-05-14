package test.thread;

public class TestThreadInterupt {

	public static void main(String[] args) {

		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("test interupt");
				Thread.currentThread().interrupt();
			}
		};
		t.start();// run方法只是一个方法，不会启动线程执行

	}

}
