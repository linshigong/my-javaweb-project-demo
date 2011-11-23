package com.SpringMVC.domain;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = -1420640960684531710L;

	String description;
	Double price;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("Description :").append(description).append(";");
		buff.append("Price :"+price);
		return buff.toString();
	}
	
}
