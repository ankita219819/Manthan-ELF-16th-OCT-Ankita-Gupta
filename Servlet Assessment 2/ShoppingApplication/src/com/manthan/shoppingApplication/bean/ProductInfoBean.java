package com.manthan.shoppingApplication.bean;

public class ProductInfoBean {

	private int product_id;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	private String product_name;
	private String description;
	private String product_color;
	private double product_cost;
	private int number_of_products;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public double getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(double product_cost) {
		this.product_cost = product_cost;
	}
	public int getNumber_of_products() {
		return number_of_products;
	}
	public void setNumber_of_products(int number_of_products) {
		this.number_of_products = number_of_products;
	}
	
	
	
}
