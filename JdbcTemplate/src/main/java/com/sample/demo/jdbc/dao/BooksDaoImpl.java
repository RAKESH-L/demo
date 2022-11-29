package com.sample.demo.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sample.demo.jdbc.model.Authors;
import com.sample.demo.jdbc.model.Books;

@Component
public class BooksDaoImpl implements BooksDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BooksDaoImpl(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Books> getAllBooks() {
		String sql = "select * from books";
		List<Books> book = jdbcTemplate.queryForList(sql, Books.class);
		return book;
	}

	@Override
	public List<Books> getAllBooksByAuthor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBook(Books book) {
		// TODO Auto-generated method stub
		String sql = "insert into books (title, price, authorid) values (?, ?, ?)";
		Object[] args = {book.getTitle(), book.getPrice(), book.getAuthorId()};
		
		int res = jdbcTemplate.update(sql, args);
		if(res > 0) {
			System.out.println("Book Details Updated");
			
		}else {
			System.out.println("Unable to add new book. try later");
		}
	}

	@Override
	public void updateBook(Books book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(int id) {
		
		
	}

	@Override
	public Books getById(int id) {
		String sql = "select * from books where bookid = " + id;
		Books book = jdbcTemplate.queryForObject(sql, new BookMapper());
		return book;		
	}

}
