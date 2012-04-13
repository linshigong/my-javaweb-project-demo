package test.hook;

/**
 * HOOK 程序关闭前做处理工作
 * kill -15 xxx
 * @author wb_shen.chengs
 *
 */
class test {

	public static void main(String[] args) throws Exception {

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("do something before program shutdown...");
			}
		});

		int i = 0;
		while (true) {
			Thread.sleep(1000);
			System.out.println("test");
			i++;
		}
	}

}