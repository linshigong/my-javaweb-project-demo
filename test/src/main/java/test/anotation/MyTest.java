package test.anotation;

public class MyTest {

	@TestAnotation()
	public void test(){
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		
		MyTest.class.getAnnotations();
		
		System.out.println("test");
	}
	
}
