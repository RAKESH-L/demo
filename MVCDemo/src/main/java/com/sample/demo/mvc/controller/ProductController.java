package com.sample.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.demo.mvc.dao.ProductsDao;
import com.sample.demo.mvc.entity.Products;

@Controller
public class ProductController {
	
	@Autowired
	private ProductsDao dao;
	
	@RequestMapping("/viewproducts")
	public String viewproducts(Model m) {
		List<Products> pList = dao.getAllProducts();
		m.addAttribute(pList);
		return "viewproducts";
		
	}
}
