package test.designpatten.Decorator.chunkedoutputexample;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.httpclient.ChunkedInputStream;
import org.apache.commons.httpclient.ChunkedOutputStream;

/**
 * 装饰OutputStream以支持chunked输出
 * 
 * PS:Decorator patten
 * 
 * @see {@link ChunkedOutputStream} and {@link ChunkedInputStream}<br>
 * 下面是其类注释(chunk以buffer大小为单位，数据完整性如何保证？)
 * Implements HTTP chunking support. Writes are buffered to an internal buffer (2048 default size).
 * Chunks are guaranteed to be at least as large as the buffer size (except for the last chunk).
 * 
 */
public class ChunedOutputStream extends OutputStream {

    private static final byte CRLF[] = new byte[] {(byte) 13, (byte) 10};

    /** End chunk */
    private static final byte ENDCHUNK[] = CRLF;

    /** 0 */
    private static final byte ZERO[] = new byte[] {(byte) '0'};
	
	private OutputStream out;
	
	public ChunedOutputStream(OutputStream out) {
		if(out == null){
			throw new RuntimeException("out can't be null");
		}
		this.out = out;
	}

	@Override
	public void write(int b) throws IOException {
		out.write(b);
		
	}
	
	/**
	 * 写入一个数据chunk
	 */
	public void writeDataChunk(List<Object> objectList){
		
		
	}
	
	public void writeListIntoChunks(List<Object> objectList,int numOfObjectPerChunk){
		//TODO
		
	}
	
	protected void writeClosingChunk() throws IOException {
        // Write the final chunk.
        out.write(ZERO, 0, ZERO.length);
        out.write(CRLF, 0, CRLF.length);
        out.write(ENDCHUNK, 0, ENDCHUNK.length);
    }
	
	public void setOut(OutputStream out) {
		this.out = out;
	}
}
