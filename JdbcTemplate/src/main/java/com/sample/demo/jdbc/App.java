package com.sample.demo.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.demo.jdbc.config.AppConfig;
import com.sample.demo.jdbc.dao.AuthorsDao;
import com.sample.demo.jdbc.dao.BooksDao;
import com.sample.demo.jdbc.model.Authors;
import com.sample.demo.jdbc.model.Books;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AuthorsDao dao1 = context.getBean(AuthorsDao.class);
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BooksDao dao2 = ctx.getBean(BooksDao.class);
        
        Authors author = new Authors("Rakesh", "rakesh@gmail.com");
        dao1.saveAuthor(author);
        
        Books book = new Books("lord of rings", 1200, 1);
        dao2.saveBook(book);
        
        context.close();
    }
}
