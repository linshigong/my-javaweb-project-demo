package test.thread;

import java.util.Date;

public class Child2 extends Parent {

	@Override
	public void test() {
		System.out.println(this.date);
	}
	
	@Override
	public void setDate(Date date) {
		super.setDate(date);
	}
}
