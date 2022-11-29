package com.sample.demo.jdbc.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sample.demo.jdbc.model.Authors;

@Component
public class AuthorsDaoImpl implements AuthorsDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AuthorsDaoImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public Authors getAuthorById(int id) {
		String sql = "select * from authors where authorid = " + id;
		Authors author = jdbcTemplate.queryForObject(sql, new AuthorMapper());
		return author;
	}

	@Override
	public void saveAuthor(Authors author) {
		String sql = "insert into authors (authorname, email) values (?, ?)";
		Object[] args = {author.getAuthorName(), author.getEmail()};
		
		int res = jdbcTemplate.update(sql, args);
		if(res > 0) {
			System.out.println("Author Details Updated");
			
		}else {
			System.out.println("Unable to add new author. try later");
		}
		
	}

	@Override
	public void updateAuthor(Authors author) {

		String sql = "update author set email = ? where authorid= ?";
		Object[]args = {author.getEmail(), author.getAuthorId()};
		
		int res = jdbcTemplate.update(sql, args);
		if(res > 0) {
			System.out.println("Email for author with id: " + author.getAuthorId() + ", updated");
			
		}else {
			System.out.println("Unable to update email for author id: " + author.getAuthorId());
		}
		
	}

	@Override
	public void deleteAuthor(int id) {

		String sql = "delete from author where authorid = " +id;
		
		int res = jdbcTemplate.update(sql);
		
		if (res > 0) {
			System.out.println("Author with id " +id+ ", deleted");
		}else {
			System.out.println("unable to delete author");
		}
	}

	
	

}
