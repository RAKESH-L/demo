package com.sample.demo.jdbc.dao;

import com.sample.demo.jdbc.model.Authors;

public interface AuthorsDao {
	public Authors getAuthorById(int id);
	public void saveAuthor(Authors author);
	public void updateAuthor(Authors author);
	public void deleteAuthor(int id);
}
