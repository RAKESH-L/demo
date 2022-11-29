package com.sample.demo.jdbc.dao;

import java.util.List;

import com.sample.demo.jdbc.model.Books;

public interface BooksDao {
	public List<Books> getAllBooks();
	public List<Books> getAllBooksByAuthor(int id);
	public void saveBook(Books book);
	public void updateBook(Books book);
	public void deleteBook(int id);
	public Books getById(int id);
}
