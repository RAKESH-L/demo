package com.spring.app;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.app.dao.CarsDao;
import com.spring.app.model.Cars;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        CarsDao dao = ctx.getBean("carsDao", CarsDao.class);
        
//        Cars c = new Cars();
//        c.setCarId(1);
//        c.setCarName("BMW X3");
//        c.setBrand("BMV");
//        c.setDescription("5 Seater SUV");
//        c.setPrice(240);
//        
//        dao.save(c);
        
        List<Cars> list = dao.getAll();
//      
      for (Cars c1: list) {
      	System.out.println(c1);
      }
    }
}


//<bean id="buyerDao" class="com.spring.app.dao.BuyerDaoImpl">
//<property name="dataSource" ref="ds"></property>
//</bean>
//<bean id="sellerDao" class="com.spring.app.dao.sellerDaoImpl">
//<property name="dataSource" ref="ds"></property>
//</bean>
//<bean id="purchaseDao" class="com.spring.app.dao.PurchaseDaoImpl">
//<property name="dataSource" ref="ds"></property>
//</bean>