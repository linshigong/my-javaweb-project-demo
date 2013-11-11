package test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class testUDPSocket {

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					//Client
					while(true){
						DatagramSocket datagramSocket = new DatagramSocket();
	
						DatagramPacket dataPacket = new DatagramPacket(new byte[1024], 1024);
						dataPacket.setAddress(InetAddress.getByName("localhost"));
						dataPacket.setPort(1339);
						dataPacket.setData("Hello Server".getBytes());
						datagramSocket.send(dataPacket);
	
						datagramSocket.receive(dataPacket);
						System.out.println("Client received:"+new String(dataPacket.getData()));
						
						Thread.sleep(1000 * 3);
						
					}
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {

				try {
					//Server
					DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress("localhost", 1339));

					DatagramPacket dataPacket = new DatagramPacket(new byte[1024], 1024);
					datagramSocket.setBroadcast(true);
					
					while(true){
						datagramSocket.receive(dataPacket);
						System.out.println("Server received data:"+new String(dataPacket.getData()));
						
						//Respone
						dataPacket.setData("hello client".getBytes());
						datagramSocket.send(dataPacket);
					}
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
	}
}
