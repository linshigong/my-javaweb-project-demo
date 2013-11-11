package test.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		
		
		//是否为同一天判断
		String startTimeStr = "2011-02-02 19:10:10";
		String endTimeStr = "2011-02-03 01:10:10";
		
		Date startTime = null;
		Date endTime = null;
		try{
			startTime = df.parse(startTimeStr);
			endTime = df.parse(endTimeStr);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calStart = Calendar.getInstance();
		calStart.setTime(startTime);
		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(endTime);
		if(!((endTime.getTime() - startTime.getTime() <= 24*3600*1000) && calStart.get(Calendar.DAY_OF_YEAR)== calEnd.get(Calendar.DAY_OF_YEAR))){
			System.out.println("different day");
		}else{
			System.out.println("same day");
		}
		
		//
		int i = 2;
		System.out.println(i);
	}
	
}
