package test;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.annotate.JsonValue;

public class Pojo implements Serializable{
	
	@JsonProperty(value="myId")
	String id;
	
	String name;
	
	public Pojo() {
	}

	public Pojo(String id, String name) {
		this.id = id;
		this.name = name;
	}


	
	public String getId() {
		return id;
	}
	@JsonSetter(value="id1")
	public void setId(String id) {
		this.id = id;
	}
	@JsonValue(value=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id="+this.id+" name="+this.name;
	}
	
}
