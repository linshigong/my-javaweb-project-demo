package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.digester.RegexMatcher;
import org.apache.commons.digester.SimpleRegexMatcher;

public class RegExTest{

	public static void main(String[] args) {
		
		String patten = "^[a-zA-Z0-9]{1,48}-[0-9]{0,75}$";
		String patten2 = "^[a-zA-Z0-9-]{0,75}$";
		
		Pattern p1 = Pattern.compile(patten);
		Pattern p2 = Pattern.compile(patten2);
		
		Matcher m1 = p1.matcher("12-12");
		System.out.println(m1.matches());//true
		m1 = p1.matcher("12-12-");
		System.out.println(m1.matches());//false
		
		Matcher m2 = p2.matcher("12-12");
		System.out.println(m2.matches());//true
		
	}
	
}
