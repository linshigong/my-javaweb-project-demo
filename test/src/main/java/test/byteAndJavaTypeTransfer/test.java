package test.byteAndJavaTypeTransfer;

public class test {
	
	public static void main(String[] args) {
		
		try {
			byte[] bytes = DataChange.longToByte(100L);
		
			System.out.println(DataChange.byteToLong(bytes));
			
		} catch (DataTranslateException e) {
			e.printStackTrace();
		}
	}
	
	
}
