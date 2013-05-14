package test.CRC32;

import java.util.zip.CRC32;

public class test {

	public static void main(String[] args) {
		
		String value1 = "hello";
		
		CRC32 crc = new CRC32();
		crc.update(value1.getBytes());
		System.out.println("value1="+value1+" crc32="+crc.getValue());//value1=hello crc32=907060870
		
		//
		String value2 = "Hello";
		
		crc.reset();//将crc32值reset为初始值0，若不reset会影响结果值
		
		crc.update(value2.getBytes());
		System.out.println("value2="+value2+" crc32="+crc.getValue());//value2=Hello crc32=4157704578
		
	}
	
}
