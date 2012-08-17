package test.string;

public class TestString {

	public static void main(String[] args) {
		
		Integer num = null;
		
		System.out.println(String.valueOf(num));//null字符串
		
		
		StringBuffer sb = new StringBuffer();
		System.out.println("result="+sb.toString());//返回空result=
	
		StringBuilder sb2 = new StringBuilder();
		System.out.println("sb="+sb2.substring(0, 0));
		
		/*  split */
		String ipListStr = "10.10.10.1,,10.10.10.2";
		String[] ipArr = ipListStr.split(",");
		System.out.println("ip size="+ipArr.length);
		for(String ip:ipArr){
			System.out.print(ip+", ");
		}
		
	}
	
}
