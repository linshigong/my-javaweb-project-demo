package test.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class TestDate {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println(df.parse("2012-04-06 10:00:00").getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(new Date(1334077200 * 1000L));
		
		System.out.println(new Date().getTime()/1000);
	}
	
}
