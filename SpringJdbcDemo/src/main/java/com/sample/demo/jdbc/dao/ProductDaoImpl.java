package com.sample.demo.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.demo.jdbc.model.Products;

public class ProductDaoImpl implements ProductsDao{

	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public void save(Products product) {
		
	}

	@Override
	public List<Products> getAll() {
		String sql = "SELECT * FROM pRODUCTS";
		List<Products> list = new ArrayList<Products>();
		
		Connection con = null;
		try {
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Products p = new Products();
				p.setProductId(rs.getInt("PRODUCTID"));
				p.setProductName(rs.getString("PRODUCTNAME"));
				p.setDescription(rs.getString("DESCRIPTION"));
				p.setBrand(rs.getString("Brand"));
				p.setPrice(rs.getDouble("PRICE"));
				
				list.add(p);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}

	@Override
	public Products getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Products product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
