package com.sample.demo.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.demo.jdbc.model.Authors;

public class AuthorMapper implements RowMapper<Authors>{

	@Override
	public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authors author = new Authors();
		author.setAuthorId(rs.getInt("AUTHORID"));
		author.setAuthorName(rs.getString("AUTHORNAME"));
		author.setEmail(rs.getString("EMAIL"));
		return author;
	}

}
