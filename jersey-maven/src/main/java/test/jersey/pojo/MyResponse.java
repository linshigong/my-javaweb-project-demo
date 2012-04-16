package test.jersey.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class MyResponse {
	
	private String id;
	
	private String name;
	
	private int age;
	
	public MyResponse(){}
	
	public MyResponse(String id,String name,int age){
		this.id = id;
		this.name = name;
	}
	
	@XmlElement(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
