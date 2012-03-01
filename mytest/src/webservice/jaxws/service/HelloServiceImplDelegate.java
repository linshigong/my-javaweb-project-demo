	package webservice.jaxws.service;

	import webservice.jaxws.pojo.Customer;

@javax.jws.WebService(
targetNamespace = 
	"http://service.webservice/"
,
serviceName = 
	"HelloServiceImplService"
, 
portName =
	"HelloServiceImplPort"
	,wsdlLocation = "WEB-INF/wsdl/HelloServiceImplService.wsdl"
)



public class HelloServiceImplDelegate {

	webservice.jaxws.service.HelloServiceImpl helloServiceImpl = new webservice.jaxws.service.HelloServiceImpl();

			public Customer selectMaxAgeStudent(Customer c1, Customer c2)  {		
			return helloServiceImpl.selectMaxAgeStudent(c1,c2);
		}
				public Customer selectMaxLongNameStudent(Customer c1, Customer c2)  {		
			return helloServiceImpl.selectMaxLongNameStudent(c1,c2);
		}
	
}