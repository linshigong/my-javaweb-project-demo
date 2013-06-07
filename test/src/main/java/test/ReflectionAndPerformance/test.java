package test.ReflectionAndPerformance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.cglib.beans.BeanMap;

import org.eclipse.jetty.server.Request;


/**
 * 测试不同方式下的属性注入性能对比
 * 
 * 反射
 * cglib
 * 
 */
public class test {

	public static void main(String[] args) {
		
		long loops = 1000000;
		
		final Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", "jack");
		map.put("age", "100");
		HttpServletRequest request = new Request(){
			@Override
			public String getParameter(String name) {
				return (String)map.get(name);
			}
		};

		testReflection1(loops,request);//=5879
		
		testReflection2(loops,request);//=1518
		
		testCglibBeanMap(loops,request);//=2869
		
	}

	
	private static void testCglibBeanMap(long loops,HttpServletRequest request) {
		Date start = Calendar.getInstance().getTime();
		for(int i=0;i<loops;i++){
			try {
				User u = (User)copyByCglibBeanMap(User.class, request);
				u.getUserName();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("="+(Calendar.getInstance().getTime().getTime() - start.getTime()));
		
	}


	private static void testReflection1(long loops,HttpServletRequest request) {
		Date start = Calendar.getInstance().getTime();
		for(int i=0;i<loops;i++){
			try {
				User u = (User)copyByReflection1(User.class, request);
				u.getUserName();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("="+(Calendar.getInstance().getTime().getTime() - start.getTime()));
	}
	
	private static void testReflection2(long loops,HttpServletRequest request) {
		Date start = Calendar.getInstance().getTime();
		for(int i=0;i<loops;i++){
			try {
				User u = (User)copyByReflection2(User.class, request);
				u.getUserName();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("="+(Calendar.getInstance().getTime().getTime() - start.getTime()));
	}


	public static Object copyByReflection1(Class<?> classType, HttpServletRequest request)
			throws Exception {
		Field[] fields = classType.getDeclaredFields();

		Object object = classType.newInstance();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			String fieldName = field.getName();

			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });

			Object value = request.getParameter(fieldName);
			if (null != value) {
				setMethod.invoke(object, new Object[] { value });
			}
		}

		return object;
	}
	
	public static Object copyByReflection2(Class<?> classType, HttpServletRequest request) {
		Field[] fields = classType.getDeclaredFields();

		Object object = null;
		try {
			object = classType.newInstance();
			for (Field field: fields) {
				field.setAccessible(true);
				String fieldName = field.getName();

				Object value = request.getParameter(fieldName);
				if (null != value) {
					field.set(object, value);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		

		return object;
	}
	
	public static Object copyByCglibBeanMap(Class<?> classType, HttpServletRequest request)
			throws Exception {
		Object obj = classType.newInstance();
		BeanMap beanMap = BeanMap.create(obj);
		Field[] fields = classType.getDeclaredFields();
		
		for (Field field: fields) {
			String key = field.getName();
			String value = request.getParameter(key);
			
			if (null != value) {
				Class<?> type = field.getType();
				beanMap.put(obj, key, type.cast(value));
			}
		}
		return obj;
	}
}




class User{
	private String userName;
	
	private String age;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "name="+this.userName+" age="+this.age;
	}
}