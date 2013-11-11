package test.json;

import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class pojo {
	
	
	private String id;
	
	private String name;
	
	public pojo(){}
	
	public pojo(String id,String name){
		this.id = id;
		this.name = name;
	}
	
	@JsonIgnore(value=true)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty(value="my_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:"+id+" name:"+name;
	}
}
