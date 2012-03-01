package webservice.jaxws.service;


import webservice.jaxws.pojo.Customer;

/**
 * 服务提供接口
 * @author Administrator
 *
 */
public interface IHelloService {
	
	/**
	 * 比较传入的2个 Customer 对象 ，返回age最大的那个</p>
	 * 
	 * 注：此接口方法并没有处理异常，只为演示用；实际接口实现类在出现异常时应该抛出相应异常，以告知调用者
	 * @param c1
	 * @param c2
	 * @return 返回age最大的那个Customer
	 */
	public Customer selectMaxAgeStudent(Customer c1,Customer c2);
	
	/**
	 * 比较传入的2个 Customer 对象，返回名字最长的那个
	 * @param c1
	 * @param c2
	 * @return 返回名字最长的那个Customer
	 */
	public Customer selectMaxLongNameStudent(Customer c1,Customer c2);
	
}
