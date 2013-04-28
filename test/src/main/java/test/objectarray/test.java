package test.objectarray;

public class test {

	public static void main(String[] args) {
		
		test[] strArr = new test[2];
		System.out.println(strArr.length);
		
		strArr[0] = new test();
		strArr[1] = new test();
		System.out.println(strArr.length);
		/*
		 * C:\Users>jmap -histo:live 5768 |grep test
		 124:             1             24  [Ltest.objectarray.test
		 135:             2             16  test.objectarray.test
		 */
		
	}
	
}
