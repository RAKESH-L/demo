package com.sample.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.demo.mvc.entity.Products;

public class ProductMapper implements RowMapper<Products>{

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

}
