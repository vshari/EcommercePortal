package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class AdminController {
	
	//define 3 methods
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	
	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedCategories","true");
		//get the categories from db
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList",categoryList);
		mv.addObject("category",category);
		
		return mv;
	}
	@RequestMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedProducts","true");
		//get the categories from db
		List<Product> productList = productDAO.list();
		mv.addObject("productList",productList);
		mv.addObject("Product",product);
		return mv;
	}
	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSuppliers()
	{
		System.out.println("manageSuppliers");
		ModelAndView mv = new ModelAndView("/AdminHome");
		mv.addObject("isUserClickedSuppliers","true");
		//get the categories from db
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList",supplierList);
		mv.addObject("Supplier",supplier);
		return mv;
		
	}
	

}
