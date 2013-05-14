package test.consistenthash;

import org.eclipse.jetty.util.security.Credential.MD5;

public class HashFunction {

	public Integer hash(Object key) {
		return hash(MD5.digest(key.toString()));
	}

	
	
}
