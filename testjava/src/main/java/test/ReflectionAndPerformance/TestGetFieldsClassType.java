package test.ReflectionAndPerformance;

import java.lang.reflect.Field;

import test.json.pojo;

public class TestGetFieldsClassType {

    public static void main(String[] args) {
        
        
        for(Field f: pojo.class.getDeclaredFields()){
            StringBuilder sb = new StringBuilder();
            sb.append("\n").append(f.getDeclaringClass());//class test.json.pojo
            sb.append("\n").append(f.getClass());//class java.lang.reflect.Field
            sb.append("\n").append(f.getType());//class java.lang.String
            
            Class<?> c = f.getType();
            Object obj = c.cast("abc");
            
            pojo pojo = new pojo();
            try {
                f.setAccessible(true);
                f.set(pojo, obj);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(pojo);
            System.out.println(sb.toString());
        }
        
    }
    
}
