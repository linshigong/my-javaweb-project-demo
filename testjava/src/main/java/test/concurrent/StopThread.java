package test.concurrent;

public class StopThread {
	
    private static boolean stopRequested = false;
    
    public static void main(String[] args) {
        Thread bgThread = new Thread(new Runnable() {
            public void run() {
            	/*
                int i = 0;
                while (!stopRequested)
                	System.out.println("run");
                    i++;
                */
                int i = 0;
                if (!stopRequested) {
                    while (true){
                    	System.out.println("run");
                        i++;
                    }
                }
            }
        });
        bgThread.start();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("change");
        stopRequested = true;
    }
}
