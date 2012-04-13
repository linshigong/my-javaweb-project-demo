package test.thread;

import java.util.Date;

public abstract class Parent {

	public Date date = new Date();
	
	public void test(){
		System.out.println(this.date);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
