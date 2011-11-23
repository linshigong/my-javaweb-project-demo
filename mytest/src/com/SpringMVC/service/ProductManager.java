package com.SpringMVC.service;

import java.io.Serializable;
import java.util.List;

import com.SpringMVC.domain.Product;

public interface ProductManager extends Serializable {

	/**
	 * 用接口的理由？
	 * We have chosen to make it an interface instead of a concrete class
	   for an number of reasons. First of all, it makes writing unit tests 
	   for Controllers easier (as we'll see in the next chapter). Secondly, 
	   the use of interfaces means JDK proxying (a Java language feature) 
	   can be used to make the service transactional instead of CGLIB (
	   a code generation library).
	 */
	
	public void increasePrice(int percentage);
	
	public List<Product> getProducts();
	
}
