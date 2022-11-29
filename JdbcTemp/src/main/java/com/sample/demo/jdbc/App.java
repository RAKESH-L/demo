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
        
//        List<Products> list = dao.getAll();
//        
//        for (Products p: list) {
//        	System.out.println(p);
//        }
        
        Products p1 = dao.getById(102);
        
        System.out.println(p1.toString());
        
        Products p = new Products();
        p.setProductId(1);
        p.setProductName("Sharpner");
        p.setDescription("Pencil Sharpner");
        p.setBrand("Netraja");
        p.setPrice(12);
        
        dao.save(p);
    }
}
