package com.sample.demo.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.demo.jdbc.model.Books;

public class BookMapper implements RowMapper<Books>{

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		Books book = new Books();
		book.setBookId(rs.getInt("BOOKID"));
		book.setTitle(rs.getString("TITLE"));
		book.setPrice(rs.getDouble("PRICE"));
		book.setAuthorId(rs.getInt("AUTHORID"));
		return book;
	}

}
