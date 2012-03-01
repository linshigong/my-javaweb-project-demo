package webservice.client.jaxwsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@javax.jws.WebService(endpointInterface = "webservice.client.jaxwsclient.QqOnlineWebServiceSoap", targetNamespace = "http://WebXml.com.cn/", serviceName = "qqOnlineWebService", portName = "qqOnlineWebServiceSoap", wsdlLocation = "WEB-INF/wsdl/qqOnlineWebService.wsdl")
public class qqOnlineWebServiceSoapImpl {

	public String qqCheckOnline(String qqCode) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}