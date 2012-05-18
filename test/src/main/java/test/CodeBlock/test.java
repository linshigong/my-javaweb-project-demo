package test.CodeBlock;

/**
 * 测试 java的4种代码块 
 */
public class test {

	int i;
	
	static{
		System.out.println("静态代码块1");
	}
	
	{	//先于构造函数执行
		System.out.println("构造代码块2");
		i = 10;
		
	}
	
	test(){
		System.out.println("构造方法3");
	}
	
	public static void main(String[] args) {
		test t = new test();
		System.out.println(t.i);
	}

	
}
