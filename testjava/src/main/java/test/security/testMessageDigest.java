package test.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

/**
 * MD5计算后，返回一个128Bit的大整数
 */
public class testMessageDigest {

	public static void main(String[] args) {
		
		for(Provider p:Security.getProviders()){
//			System.out.println(p.getInfo()+"\n");
		}
		
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			byte[] bytes1 = digest.digest("hello".getBytes());
			
			byte[] bytes2 = digest.digest("hellohellohellohellohello".getBytes());
			
			byte[] bytes3 = digest.digest("世界".getBytes());
			
			System.out.println(
					" bytes1="+bytes1.length+
					" bytes2="+bytes2.length+
					" bytes3="+bytes3.length
					);// bytes1=16 bytes2=16 bytes3=16 ，即占用 128bit
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
}
