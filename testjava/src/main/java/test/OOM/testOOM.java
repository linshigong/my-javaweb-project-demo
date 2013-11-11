package test.OOM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试OOM异常，jvm dump heap内存
 * 
 * jvm参数配置：
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=d:\\tmp
 * 
 */
public class testOOM{
	
	public static void main(String[] args) {
		/*
		 * set JVM parameters for head dump when OOM happens
		 * -XX:+HeapDumpOnOutOfMemoryError
		 * -XX:HeapDumpPath=d:\\tmp
		 * 
		 * set at run configure(+ is add,- is remove ,be care)
		 * 
		 * eg output:
		 * 
		 * java.lang.OutOfMemoryError: Java heap space
			Dumping heap to d:\\tmp\java_pid4608.hprof ...
			Heap dump file created [68393251 bytes in 0.462 secs]
			Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
				at java.util.HashMap.<init>(HashMap.java:187)
				at java.util.HashMap.<init>(HashMap.java:199)
				at test.OOM.testOOM.main(testOOM.java:28)

		 */
		
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		while(true){
			list.add(new HashMap<String, String>(10000));
		}
	}
}
