package test.primarydatatype;

/**
 * byte 1个字节（8个bit） short 2个字节 char 2个字节 int 4个字节 long 8个字节 float 4个字节 double
 * 8个字节
 */
public class test {

	public static void main(String[] args) {

		System.out.println("max byte=" + Byte.MAX_VALUE + " min byte="
				+ Byte.MIN_VALUE + " byte占用二进制位数=" + Byte.SIZE);//max byte=127 min byte=-128 byte占用二进制位数=8
		
		System.out.println("integer bits="+Integer.SIZE);//integer bits=32
		
		System.out.println("Long bits="+Long.SIZE);//Long bits=64
		
		System.out.println("Float bits="+Float.SIZE);//Float bits=32
		
		System.out.println("Double bits="+Double.SIZE);//Double bits=64
	}

}
