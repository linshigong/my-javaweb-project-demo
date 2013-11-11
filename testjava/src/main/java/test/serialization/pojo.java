package test.serialization;

import java.io.Serializable;

public class pojo implements Serializable {
	
	private static final long serialVersionUID = -2212339035677808301L;

	private int age;
	
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name="+name+" age="+age;
	}
}
