package webservice.jaxws.service;


import webservice.jaxws.pojo.Customer;

public class HelloServiceImpl implements IHelloService {
	
	@Override
	public Customer selectMaxAgeStudent(Customer c1, Customer c2) {
		if(c1.getBirthday().getTime() > c2.getBirthday().getTime()){
			return c1;
		}else{
			return c2;
		}
	}

	@Override
	public Customer selectMaxLongNameStudent(Customer c1, Customer c2) {
		if(c1.getName().length() > c2.getName().length()){
			return c1;
		}else{
			return c2;
		}
	}

}
