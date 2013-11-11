package test.string;

import java.util.Formatter;


public class TestStringFormatOutput {

	public static void main(String[] args) {
		
		System.out.printf("%s is number %d!", "Tom",1);//Tom is number 1!
		
		System.out.println(new Formatter().format("%s is number %d!", "Tom",1).toString());
		
		//
		String lbIds[] = new String[]{"a","b","c"};
		System.out.println(String.format("Url encoding error,lbId=%s",lbIds[0]));
	}
	
}
