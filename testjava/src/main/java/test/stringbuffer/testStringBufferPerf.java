package test.stringbuffer;

import org.apache.commons.lang.math.RandomUtils;

public class testStringBufferPerf {

    public static void main(String[] args) {
        int num = 10000;
        String str = "a" + String.valueOf(RandomUtils.nextInt(num));
        
        long wait = 3000;
        
        sleep(wait);
        strAppend1(str, num);
        
        sleep(wait);
        strAppend2(str, num);
        
        sleep(wait);
        strAppend3(str, num);
        
    }
    
    public static void strAppend1(String str, int num){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < num; i++){
            sb.append(str);
        }
    }
    
    public static void strAppend2(String str, int num){
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < num; i++){
            sb.append(str);
        }
    }
    
    public static void strAppend3(String str, int num){
        String a = "";
        for(int i = 0; i < num; i++){
            a = a + str;
        }
    }
    
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
