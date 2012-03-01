package webservice.jaxws.server;

import javax.xml.ws.Endpoint;

import webservice.jaxws.service.HelloServiceImpl;

public class SoapServer {

	
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8080/mytestsvn/helloService", new HelloServiceImpl());
	}
	
}
