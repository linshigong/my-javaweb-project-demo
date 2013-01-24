package test;

public enum EnumTest {

	NAME("a",1),
	AGE,
	ADDRESS,
	HEIGHT;
	
	private String name;
	private int age;
	
	EnumTest(){}
	
	EnumTest(String str,int num){
		name = str;
		age = num;
	}
	
	public static void main(String[] args) {
		for(Object o:EnumTest.values()){
			System.out.println((Enum)o);
		}
		
		//test equal method of enum
		System.out.println(EnumTest.ADDRESS == EnumTest.ADDRESS);//true
		
	}
	
}
