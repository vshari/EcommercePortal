package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {

	// get all product
	public List<Product> list();

	// create product
	public boolean save(Product product);

	// update product
	public boolean update(Product product);
	
	//delete product by id
	public boolean delete(int id);
	//delete category by name
		public boolean deletebyname(String name);

	// delete product by product
	public boolean delete(Product product);

	// get product by id
	//public Product getProductByID(int id);

	// get product by name
	public Product getProductBYName(String name);

	public Product getProductByID(int id);

}
