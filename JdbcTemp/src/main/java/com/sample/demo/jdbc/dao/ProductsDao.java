package com.sample.demo.jdbc.dao;

import java.util.List;

import com.sample.demo.jdbc.model.Products;

public interface ProductsDao {
	public void save(Products product);
	public List<Products> getAll();
	public Products getById(int id);
	public void update(Products product);
	public void deleteById(int id);
}
