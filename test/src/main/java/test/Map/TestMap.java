package test.Map;

import java.util.HashMap;
import java.util.Map;

import test.Pojo;


/**
 * 址传递
 * @author wb_shen.chengs
 *
 */
public class TestMap {

	public static void main(String[] args) {
		
		Map<String,Pojo> map = new HashMap<String, Pojo>();
		
		/*
		map.put("1", new Pojo("id1","name1"));
		map.put("2", new Pojo("id1","name1"));
		System.out.println("init :" + map.get("1").getName());// init :name1
		
		Pojo p = map.get("1");
		p.setName("new name");
		System.out.println("modified :" + map.get("1").getName());// modified :new name
		System.out.println("aa"+map);
		*/
		
		map.put("name", new Pojo("lower case", "name"));
		map.put("NAME", new Pojo("upper case", "name"));
		
		System.out.println(map.get("name"));
		System.out.println(map.get("NAME"));
	}
	
}
