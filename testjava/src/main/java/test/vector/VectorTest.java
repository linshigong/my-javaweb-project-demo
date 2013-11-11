package test.vector;

import java.util.HashMap;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		Vector<Object> v= new Vector<Object>();
		
		try{
		for(int i=0;i<1000000;i++){
			Object obj = new HashMap<String, String>(100000);
			System.out.println("i="+i+" obj="+obj);
			v.add(obj);
			obj = null;
			System.out.println("i="+i+" obj="+v.get(i));
			obj = new String("efg");
			System.out.println("i="+i+" obj="+obj);
			System.out.println();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(v);
	}
	
}
