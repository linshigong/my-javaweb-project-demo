package test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * nio实现的时间服务例子
 */
public class MyServer {

	public static void main(String[] args) {

		try {
			ServerSocketChannel sc = ServerSocketChannel.open();
			sc.configureBlocking(false);
			sc.socket().bind(new InetSocketAddress("localhost", 55555));
			Selector s = Selector.open();
			System.out.println("selector provider="+s.provider());
			sc.register(s, SelectionKey.OP_ACCEPT);
			while (true) {
				int keyNums = s.select(1000 * 1);
				if(keyNums == 0){
					continue;
				}
//				sc.accept();
				//get date	
				ByteBuffer bBuffer = ByteBuffer.allocate(100);
				bBuffer.put(new Date().toString().getBytes());

				Set<SelectionKey> keys = s.selectedKeys();
				Iterator<SelectionKey> i = keys.iterator();
				while(i.hasNext()){
					SelectionKey selection = i.next();
					SocketChannel c = (SocketChannel)selection.channel();
					System.out.println("user address:"+c.socket().getInetAddress());
					c.write(bBuffer);
					bBuffer.flip();
				}
//				System.out.println(s.provider());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
