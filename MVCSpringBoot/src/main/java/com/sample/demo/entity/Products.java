package com.sample.demo.entity;


public class Products {

	private int productId;
	private String productName;
	private String description;
	private String brand;   
	private double price;
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Products(int productId, String productName, String description, String brand, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
