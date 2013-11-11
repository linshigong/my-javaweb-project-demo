package test.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Copyright 2007 GuangZhou Cotel Co. Ltd.
 * All right reserved.    
 * UDP客户端程序，用于对服务端发送数据，并接收服务端的回应信息.
 * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
 * @version 1.0 
 * Creation date: 2007-8-16 - 下午10:54:23
 */
public class UdpClientSocket {
    private byte[] buffer = new byte[1024];

    private DatagramSocket ds = null;

    /**
     * 构造函数，创建UDP客户端
     * @throws Exception
     */
    public UdpClientSocket() throws Exception {
        ds = new DatagramSocket();
    }
    
    /**
     * 设置超时时间，该方法必须在bind方法之后使用.
     * @param timeout 超时时间
     * @throws Exception
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午10:55:12
     */
    public final void setSoTimeout(final int timeout) throws Exception {
        ds.setSoTimeout(timeout);
    }

    /**
     * 获得超时时间.
     * @return 返回超时时间
     * @throws Exception
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午10:55:25
     */
    public final int getSoTimeout() throws Exception {
        return ds.getSoTimeout();
    }

    public final DatagramSocket getSocket() {
        return ds;
    }

    /**
     * 向指定的服务端发送数据信息.
     * @param host 服务器主机地址
     * @param port 服务端端口
     * @param bytes 发送的数据信息
     * @return 返回构造后俄数据报
     * @throws IOException
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午11:02:41
     */
    public final DatagramPacket send(final String host, final int port,
            final byte[] bytes) throws IOException {
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress
                .getByName(host), port);
        ds.send(dp);
        return dp;
    }

    /**
     * 接收从指定的服务端发回的数据.
     * @param lhost 服务端主机
     * @param lport 服务端端口
     * @return 返回从指定的服务端发回的数据.
     * @throws Exception
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午10:52:36
     */
    public final String receive(final String lhost, final int lport)
            throws Exception {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        String info = new String(dp.getData(), 0, dp.getLength());
        return info;
    }

    /**
     * 关闭udp连接.
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午10:53:52
     */
    public final void close() {
        try {
            ds.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 测试客户端发包和接收回应信息的方法.
     * @param args
     * @throws Exception
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a>
     * Creation date: 2007-8-16 - 下午11:03:54
     */
    public static void main(String[] args) throws Exception {
        UdpClientSocket client = new UdpClientSocket();
        String serverHost = "127.0.0.1";
        int serverPort = 3344;
        client.send(serverHost, serverPort, ("你好，阿蜜果!").getBytes());
        String info = client.receive(serverHost, serverPort);
        System.out.println("client1 say: 服务端回应数据：" + info);
        
        //add by cs ,test udp broadcast
        Thread client2 = new Thread(){
            public void run() {
                try {
                    UdpClientSocket client = new UdpClientSocket();
                    while(true){
                        String serverHost = "127.0.0.1";
                        int serverPort = 3344;
                        client.send(serverHost, serverPort, ("你好，我是client2!").getBytes());
                        String info = client.receive("", 0);
                        System.out.println("client2 say: 服务端回应数据：" + info);
                        
                        Thread.sleep(5 * 1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            };
        };
        
        client2.start();
    }
}

