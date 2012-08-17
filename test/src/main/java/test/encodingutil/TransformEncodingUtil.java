package test.encodingutil;

import java.io.Console;
import java.io.File;

/**
 * encoding tool 
 */
public class TransformEncodingUtil {

	public static void main(String[] args) {
		
		/**
		 * 1. get file
		 * 2. console list encoding format symbols
		 * 3. choose source format 
		 * 4. choose target format 
		 * 5. transform from one encoding format to another
		 */
		new TransformEncodingUtil().run();
		
	}

	private void run() {
		File[] files = getFiles();
		System.out.println(files);
		
	}
	
	/**
	 * get files to be processed
	 */
	private File[] getFiles() {
		Console console = System.console();
		System.out.println("input file name with path:\n");
		String fileName = console.readLine();
		
		File f = new File(fileName);
		return new File[]{f};
	}
	
}
