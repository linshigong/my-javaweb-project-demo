package test.bitmove;

public class test {

	public static void main(String[] agrs) {
		int i = 12;
		int j = i >>> 32;
		System.out.println(j);
		
		//
		j = i >> 31;
		System.out.println(j);
	}

}
