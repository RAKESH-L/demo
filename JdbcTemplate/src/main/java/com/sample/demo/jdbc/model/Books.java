package com.sample.demo.jdbc.model;

public class Books {
	
	private int bookId;
	private String title;
	private double price;
	private int authorId;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String title, double price, int authorId) {
		super();
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}
	public Books(int bookId, String title, double price, int authorId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", price=" + price + ", authorId=" + authorId + "]";
	}
	
	
}
