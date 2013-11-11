package test.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		
		// int类型变量，如果没赋值，默认系统会赋值为0
		System.out.println(1 - new pojo().getAge());//1
		
	}

	
	static class pojo {
		int age;
		String name;

		public pojo() {
		}
		
		public pojo(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
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
	}
}
