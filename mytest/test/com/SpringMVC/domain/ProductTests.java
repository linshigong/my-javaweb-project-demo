package com.SpringMVC.domain;

import junit.framework.TestCase;

public class ProductTests extends TestCase {

	
	/**
	 * pojo类的get/set方法是否需要测试？摘自springmvc文档
	 *  Now we write the unit tests for our Product class. Some developers don't bother writing tests for getters and
		setters or so-called 'auto-generated' code. It usually takes much longer to engage in the debate (as this
		paragraph demonstrates) on whether or not getters and setters need to be unit tested as they're so 'trivial'. We
		write them because: a) they are trivial to write; b) having the tests pays dividends in terms of the time saved for
		the one time out of a hundred you may be caught out by a dodgy getter or setter; and c) they improve test
		coverage. We create a Product stub and test each getter and setter as a pair in a single test. Usually, you will
		write one or more test methods per class method, with each test method testing a particular condition in a class
		method such as checking for a null value of an argument passed into the method.
	 */
	private Product product;

	protected void setUp() throws Exception {
		product = new Product();
	}

	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}

	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}
	
}
