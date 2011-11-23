package com.SpringMVC.service.impl;

import java.util.List;

import com.SpringMVC.domain.Product;
import com.SpringMVC.service.ProductManager;

@SuppressWarnings("serial")
public class SimpleProductManager implements ProductManager {
	/**
	 * 对于暂时没有实现的方法，返回 UnsupportedOperationException 异常是一个比较好的选择
	 * 		
	 * 		throw new UnsupportedOperationException();
	 * 
	 * It's usually a good idea to mark unimplemented methods by getting them 
	 * to throw an UnsupportedOperationException.
	 */
	public List<Product> getProducts() {
		throw new UnsupportedOperationException();
	}

	public void increasePrice(int percentage) {
		throw new UnsupportedOperationException();
	}

	public void setProducts(List<Product> products) {
		throw new UnsupportedOperationException();
	}
}
