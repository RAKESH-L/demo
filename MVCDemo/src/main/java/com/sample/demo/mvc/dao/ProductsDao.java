package com.sample.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.demo.mvc.entity.Products;

public class ProductsDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Products> getAllProducts(){
		String sql = "select * from products";
		List<Products> plist = jdbcTemplate.query(sql, new RowMapper<Products>() {

			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				Products p = new Products();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setBrand(rs.getString(4));
				p.setPrice(rs.getDouble(5));
				
				return p;
			}
			
		});
		return plist;
		
	}
	
	public Products getProductsById(int id) {
		String sql = "select * from products where productid = " + id;
		Products p  = jdbcTemplate.queryForObject(sql, new ProductMapper());
		return p;
		
	}
	public int saveProduct(Products p) {
		String sql = "insert into products values (?, ?, ?, ?, ?)";
		Object[] args = {p.getProductId(), p.getProductName(), p.getDescription(),
				p.getBrand(), p.getPrice()};
		int res = jdbcTemplate.update(sql, args);
		return res;
		
	}
}
