package test.octalsystemandothers;

public class test {

	public static void main(String[] args) {
		
		Integer hashCode = 10;
		
		System.out.println(0xffffffffL);//4294967295
		System.out.println(-1L);//-1
		System.out.println(hashCode.longValue() & 0xffffffffL);//10
		
		System.out.println(1234567L & 0xffffffffL);//1234567
		
		System.out.println((1000000000000001L >> 16) & 0x7fff);
		
	}
	
}
