java security java安全相关的东西

	* MessageDigest 类
	
	例：
		private static MessageDigest getMd5Digest() {

		try {

			return MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException(e.getMessage());

		}

	}
	获得一个MD5处理对象，方便进行md5加解密等操作。