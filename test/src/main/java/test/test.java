package test;

import java.text.NumberFormat;

import org.apache.commons.collections.map.LRUMap;

public class test {

	public static void main(String[] args) {
		int code = -2050;
		if(code > 0 || code < -2100){
			System.out.println("a");
		}
		
		//
		System.out.println(1%2);
		System.out.println(2%2);
		System.out.println(1f/2);
		System.out.println(3d/9);
		System.out.println("1%50="+1%50);
		
		System.out.println(Integer.MAX_VALUE);
		
		
		//test address pass & value pass
		
		Long num = -1L;
		changeNum(num);
		System.out.println(num);//100
		
//		try {
//			Thread.sleep(1000 * 60 * 10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//
		String name = "";
		String name2 = null;
		System.out.println("name:"+name+"_not exists");//name:_not exists
		System.out.println("name2:"+name2+"_not exists");//name2:null_not exists
		
		//
		LRUMap lruMap = new LRUMap();
		lruMap.put("", "abc");
		System.out.println("LRUMap values="+lruMap);
		
		//
		System.out.println("2 pow 32="+NumberFormat.getInstance().format(Math.pow(2, 32)));//2 pow 32=4,294,967,296
		
		
	}

	
	
	private static void changeNum(Long num) {
		num = 100L;
	}

	
}
