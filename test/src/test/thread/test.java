package test.thread;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		Child1 c1 = new Child1();
		Child2 c2 = new Child2();
		//
		System.out.println(c1.date == c2.date);
		//
		c1.setDate(new Date(135890000l));
		System.out.println(c1.getDate() + " " + c2.getDate());
		
	}
	
}
