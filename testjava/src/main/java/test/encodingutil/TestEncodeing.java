package test.encodingutil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Iterator;

import sun.nio.cs.StandardCharsets;

public class TestEncodeing {

    public static void main(String[] args) throws Exception {
        
//        String str = "1";
//        
//        System.out.println(new String(str.getBytes(), ""));
        
        /* The standard set of charsets */
        CharsetProvider standardProvider = new StandardCharsets();
        Iterator<Charset> i = standardProvider.charsets();
        while(i.hasNext()){
            System.out.println(i.next().name());
        }
        
    }
    
}
