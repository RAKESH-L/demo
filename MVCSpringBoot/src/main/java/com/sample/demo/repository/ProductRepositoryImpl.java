package com.sample.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.demo.entity.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Products> getAllProducts() {
		String sql = "select * from products";
		
		List<Products> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Products.class));
		return list;
	}

	@Override
	public Products findBYId(int id) {
		String sql = "select * from products where productid = ?";
		Products p = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class), id);
		return p;
	}

	@Override
	public int save(Products p) {
		String sql = "insert into products value (?, ?, ?, ?, ?)";
		Products product = getLastRow();
		
		int id = 103;
		if(product != null) {
			id = product.getProductId() + id;
		}
		p.setProductId(id);
		Object[] args = {p.getProductId(), p.getProductName(), p.getDescription(),
				p.getBrand(), p.getPrice()};
		
		int res = jdbcTemplate.update(sql, args);
		return res;
	}

	private Products getLastRow() {
		String sql = "select * from products order by productid desc limit 1";
		Products p = null;
		try {
			p = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void update(Products p) {
		// TODO Auto-generated method stub
		String sql = "update products set price = ? where productid = ?";
		
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = {p.getPrice(), p.getProductId()};
		
		int res = jdbcTemplate.update(sql, args);
		if(res > 0){
			System.out.println("Product with id: " +p.getProductId() + " updated");
		} else {
			System.out.println("Unable to update product with id: " + p.getProductId());
		}
		
	}

	@Override
	public Products deleteById(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID = ?";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int res = jdbcTemplate.update(sql, id);
		if(res > 0) {
			System.out.println("Deleted product with id " + id);
		} else {
			System.out.println("Unable to delete product with id " + id);
		}
		return null;
	}

}
