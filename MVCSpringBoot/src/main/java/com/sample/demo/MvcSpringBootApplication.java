package com.sample.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sample.demo.entity.Products;
import com.sample.demo.repository.ProductRepository;

@SpringBootApplication
public class MvcSpringBootApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ApplicationContext ctx = SpringApplication.run(MvcSpringBootApplication.class, args);
    	ProductRepository repo = ctx.getBean(ProductRepository.class);
    	
	        System.out.println("1. Add a Product");
	        System.out.println("2. List All Products");
	        System.out.println("3. View Product Details");
	        System.out.println("4. Delete a product");
	        System.out.println("5. Edit Product details");
	        System.out.println("6. Exit");
	        System.out.print("Your Choice? ");
	        int ch = sc.nextInt();
	        
		
	        switch(ch) {
	        case 1:
	            System.out.println("Enter Product Name: ");
	            String name = sc.next();
	            
	            System.out.println("Enter Description: ");
	            String desc = sc.next();
	            
	            System.out.println("Enter brand: ");
	            String br = sc.next();
	            
	            System.out.println("Enter price: ");
	            double price = sc.nextDouble();
	            
	            Products product = new Products();
	            product.setProductId(1);
	            product.setProductName(name);
	            product.setDescription(desc);
	            product.setBrand(br);
	            product.setPrice(price);
	            
	            repo.save(product);
	            break;
	            
	        case 2:
	        	List<Products> list = repo.getAllProducts();
	        	for(Products p: list) {
	        		System.out.println(p.toString());
	        		
	        	}
	        	break;
	        case 3:
	        	System.out.println("Enter Product Id: ");
	        	int id = sc.nextInt();
	        	Products pd = repo.findBYId(id);
	        	
	        	System.out.println(pd.toString());
	        	break;
	        
	        case 4:
	        	System.out.println("Enter Product Id: ");
	        	int id1 = sc.nextInt();
	        	
	        	Products pro = repo.deleteById(id1);
	        	System.out.println(pro.toString());
	        	break;
	        case 5:
	        	System.out.println("Enter Product Id: ");
	        	int id2 = sc.nextInt();
	        	System.out.println("Enter price: ");
	            double price1 = sc.nextDouble();
	            
	            Products product1 = new Products();
	            product1.setProductId(id2);
	            product1.setPrice(price1);
	            
	            repo.update(product1);
	            break;
	        case 6:
	            sc.close();
	            System.exit(0);
	        default:
	            System.out.println("Wrong choice");
	        
	        }
	}

}
	
//	List<Products> list = repo.getAllProducts();
//	for(Products p: list) {
//		System.out.println(p.toString());
//	}
