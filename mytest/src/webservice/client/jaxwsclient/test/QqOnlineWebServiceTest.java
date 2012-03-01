package webservice.client.jaxwsclient.test;

import webservice.client.jaxwsclient.QqOnlineWebService;
import webservice.client.jaxwsclient.QqOnlineWebServiceSoap;

public class QqOnlineWebServiceTest {
	/*
	static{
		 QqOnlineWebService service = new QqOnlineWebService();
		 QqOnlineWebServiceSoap portType = service.getQqOnlineWebServiceSoap();
		 String status = portType.qqCheckOnline("516610260");
		 System.out.println(status);
	}*/

	public static void main(String[] args) {
		 QqOnlineWebService service = new QqOnlineWebService();
		 QqOnlineWebServiceSoap portType = service.getQqOnlineWebServiceSoap();
		 String status = portType.qqCheckOnline("516610260");
		 System.out.println(status);
		 
	}
	
}
