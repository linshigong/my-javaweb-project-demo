package webservice.client.jaxwsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@javax.jws.WebService(endpointInterface = "webservice.client.jaxwsclient.QqOnlineWebServiceSoap", targetNamespace = "http://WebXml.com.cn/", serviceName = "qqOnlineWebService", portName = "qqOnlineWebServiceSoap12", wsdlLocation = "WEB-INF/wsdl/qqOnlineWebService.wsdl")
@javax.xml.ws.BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class qqOnlineWebServiceSoap12Impl {

	public String qqCheckOnline(String qqCode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}