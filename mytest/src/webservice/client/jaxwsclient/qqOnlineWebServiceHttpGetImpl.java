package webservice.client.jaxwsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@javax.jws.WebService(endpointInterface = "webservice.client.jaxwsclient.QqOnlineWebServiceHttpGet", targetNamespace = "http://WebXml.com.cn/", serviceName = "qqOnlineWebService", portName = "qqOnlineWebServiceHttpGet", wsdlLocation = "WEB-INF/wsdl/qqOnlineWebService.wsdl")
public class qqOnlineWebServiceHttpGetImpl {

	public String qqCheckOnline(String qqCode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}