package test.collection;

import java.lang.reflect.Field;

public class testCollection {

    public static void main(String[] args) throws Exception {
        
        Field f = pojo.class.getDeclaredField("list");
        System.out.println(f.getType().isArray());//False
        
        //
        Field f2 = pojo.class.getDeclaredField("numArr");
        System.out.println(f2.getType().isArray());//True
    }
    
}
