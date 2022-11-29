package com.sample.demo.jdbc;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.demo.jdbc.dao.ProductsDao;
import com.sample.demo.jdbc.model.Products;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        ProductsDao dao = ctx.getBean("productDao", ProductsDao.class);
        
        List<Products> list = dao.getAll();
        
        System.out.println(list);
        
        ctx.close();
    }
}
