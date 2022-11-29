package com.sample.demo.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.demo.jdbc.model.Products;

public class ProductDaoImpl implements ProductsDao{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Products product) {

		String sql = "INSERT INTO PRODUCTS VALUES (?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Products p = getLastRow();
		
		int id = 101;
		if(p != null) {
			id = p.getProductId() + 1;
			
		}
		product.setProductId(id);
		
		Object[] args = {product.getProductId(), product.getProductName(), product.getDescription(),
				product.getBrand(), product.getPrice()};
		
		int res = jdbcTemplate.update(sql, args);
		
		if(res>0) {
			System.out.println("Product Details Inserted");
		}else {
			System.out.println("Unable to insert. Try later");
		}
		
	}

	private Products getLastRow() {
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTID DESC LIMIT 1";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Products p = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class));
		return p;
	}

	@Override
	public List<Products> getAll() {
		String sql = "SELECT * FROM PRODUCTS";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Products> list = new ArrayList<Products>();
		
		list = jdbcTemplate.query(sql, new RowMapper<Products>() {

			@Override
			public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
				Products p = new Products();
				p.setProductId(rs.getInt("PRODUCTID"));
				p.setProductName(rs.getString("PRODUCTNAME"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setBrand(rs.getString("Brand"));
				p.setPrice(rs.getDouble("PRICE"));
				
				return p;
			}
			
		});
		return list;
	}

	@Override
	public Products getById(int id) {
		
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTID = " + id;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
//		Products product = jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Products>() {
//			
//		});
		
		Products product = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Products.class));
		return product;
	}

	@Override
	public void update(Products p) {
		// TODO Auto-generated method stub
		String sql = "UPADTE PRODUCTS SET PRICE = ? WHERE PRODUCTID = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = {p.getPrice(), p.getProductId()};
		
		int res = jdbcTemplate.update(sql, args);
		if(res > 0){
			System.out.println("Product with id: " +p.getProductId() + " updated");
		} else {
			System.out.println("Unable to update product with id: " + p.getProductId());
		}
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int res = jdbcTemplate.update(sql, id);
		if(res > 0) {
			System.out.println("Deleted product with id " + id);
		} else {
			System.out.println("Unable to delete product with id " + id);
		}
		
	}

}
