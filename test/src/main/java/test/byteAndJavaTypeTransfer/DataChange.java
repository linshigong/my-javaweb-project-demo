package test.byteAndJavaTypeTransfer;

/**
 * 字节与Java基本类型的相互转换 
 */
public class DataChange {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testTime = 100;// 测试次数

		short sValue = 256;
		int iValue = -99999;
		long lValue = -99999;
		double dValue = -99999999999.99999999d;
		float fValue = -9999999999.9999f;

		outPut(shortToByte(sValue));
		try {

			System.out.println(byteToShort(shortToByte(sValue)));
		} catch (DataTranslateException e1) {
			e1.printStackTrace();
		}

		outPut(intToByte(iValue));
		try {
			System.out.println(byteToInt(intToByte(iValue)));
		} catch (DataTranslateException e) {
			e.printStackTrace();
		}

		outPut(longToByte(lValue));
		try {
			System.out.println(byteToLong(longToByte(lValue)));
		} catch (DataTranslateException e) {
			e.printStackTrace();
		}

		outPut(doubleToByte(dValue));
		try {
			System.out.println(byteToDouble(doubleToByte(dValue)));
		} catch (DataTranslateException e) {
			e.printStackTrace();
		}

		outPut(floatToByte(fValue));
		try {
			System.out.println(byteToFloat(floatToByte(fValue)));
		} catch (DataTranslateException e) {
			e.printStackTrace();
		}

	}

	private static void outPut(byte[] bytes) {
		System.out.println(new String(bytes));
	}

	/**
	 * short转换到字节数组
	 * 
	 * @param number
	 * @return
	 */
	public static byte[] shortToByte(short number) {
		byte[] b = new byte[2];
		for (int i = 1; i >= 0; i--) {
			b[i] = (byte) (number % 256);
			number >>= 8;
		}
		byte bb = (byte) 12922;

		return b;
	}

	/**
	 * 字节到short转换
	 * 
	 * @param b
	 * @return
	 * @throws DataTranslateException
	 */
	public static short byteToShort(byte[] b) throws DataTranslateException {
		if (b.length != 2)
			throw new DataTranslateException();

		return (short) ((((b[0] & 0xff) << 8) | b[1] & 0xff));
	}

	/**
	 * 整型转换到字节数组
	 * 
	 * @param number
	 * @return
	 */
	public static byte[] intToByte(int number) {
		byte[] b = new byte[4];
		for (int i = 3; i >= 0; i--) {
			b[i] = (byte) (number % 256);
			number >>= 8;
		}
		return b;
	}

	/**
	 * 字节数组到整型转换
	 * 
	 * @param b
	 * @return
	 * @throws DataTranslateException
	 */
	public static int byteToInt(byte[] b) throws DataTranslateException {
		if (b.length != 4)
			throw new DataTranslateException();
		return (int) ((((b[0] & 0xff) << 24) | ((b[1] & 0xff) << 16)
				| ((b[2] & 0xff) << 8) | ((b[3] & 0xff) << 0)));
	}

	/**
	 * long转换到字节数组
	 * 
	 * @param number
	 * @return
	 */
	public static byte[] longToByte(long number) {
		byte[] b = new byte[8];
		for (int i = 7; i >= 0; i--) {
			b[i] = (byte) (number % 256);
			number >>= 8;
		}
		return b;
	}

	/**
	 * 字节数组到整型的转换
	 * 
	 * @param b
	 * @return
	 * @throws DataTranslateException
	 */
	public static long byteToLong(byte[] b) throws DataTranslateException {
		if (b.length != 8)
			throw new DataTranslateException();
		return ((((long) b[0] & 0xff) << 56) | (((long) b[1] & 0xff) << 48)
				| (((long) b[2] & 0xff) << 40) | (((long) b[3] & 0xff) << 32)
				| (((long) b[4] & 0xff) << 24) | (((long) b[5] & 0xff) << 16)
				| (((long) b[6] & 0xff) << 8) | (((long) b[7] & 0xff) << 0));
	}

	/**
	 * double转换到字节数组
	 * 
	 * @param d
	 * @return
	 */
	public static byte[] doubleToByte(double d) {

		byte[] bytes = new byte[8];
		long l = Double.doubleToLongBits(d);
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = new Long(l).byteValue();
			l = l >> 8;
		}
		return bytes;
	}

	/**
	 * 字节数组到double转换
	 * 
	 * @param b
	 * @return
	 * @throws DataTranslateException
	 */
	public static double byteToDouble(byte[] b) throws DataTranslateException {
		if (b.length != 8)
			throw new DataTranslateException();
		long l;
		l = b[0];
		l &= 0xff;
		l |= ((long) b[1] << 8);
		l &= 0xffff;
		l |= ((long) b[2] << 16);
		l &= 0xffffff;
		l |= ((long) b[3] << 24);
		l &= 0xffffffffl;
		l |= ((long) b[4] << 32);
		l &= 0xffffffffffl;

		l |= ((long) b[5] << 40);
		l &= 0xffffffffffffl;
		l |= ((long) b[6] << 48);
		l &= 0xffffffffffffffl;

		l |= ((long) b[7] << 56);

		return Double.longBitsToDouble(l);
	}

	/**
	 * float转换到字节数组
	 * 
	 * @param d
	 * @return
	 */
	public static byte[] floatToByte(float d) {

		byte[] bytes = new byte[4];
		int l = Float.floatToIntBits(d);
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = new Integer(l).byteValue();
			l = l >> 8;
		}
		return bytes;
	}

	/**
	 * 字节数组到float的转换
	 * 
	 * @param b
	 * @return
	 * @throws DataTranslateException
	 */
	public static float byteToFloat(byte[] b) throws DataTranslateException {
		if (b.length != 4)
			throw new DataTranslateException();
		int l;
		l = b[0];
		l &= 0xff;
		l |= ((long) b[1] << 8);
		l &= 0xffff;
		l |= ((long) b[2] << 16);
		l &= 0xffffff;
		l |= ((long) b[3] << 24);
		l &= 0xffffffffl;
		return Float.intBitsToFloat(l);
	}

	/**
	 * 字符串到字节数组转换
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] stringToByte(String s) {
		return s.getBytes();
	}

	/**
	 * 字节数组带字符串的转换
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToString(byte[] b) {
		return new String(b);

	}
}

class DataTranslateException extends Exception {
	/**
	 * 数据转换异常
	 */
	private static final long serialVersionUID = -1549549583129122004L;

}
