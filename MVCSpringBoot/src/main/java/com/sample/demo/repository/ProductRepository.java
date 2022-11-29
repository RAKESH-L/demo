package com.sample.demo.repository;

import java.util.List;

import com.sample.demo.entity.Products;

public interface ProductRepository {
	
	public List<Products> getAllProducts();
	public Products findBYId(int id);
	
	public int save(Products p);
	public void update(Products p);
	public Products deleteById(int id);
}
