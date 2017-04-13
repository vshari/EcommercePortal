package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {

	// get all Supplier
	public List<Supplier> list();

	// create Supplier
	public boolean save(Supplier supplier);

	// update category
	public boolean update(Supplier supplier);
	
	//delete Supplier by id
	public boolean delete(int id);
	//delete Supplier by name
		public boolean deletebyname(String name);

	// delete Supplier by category
	public boolean delete(Supplier supplier);

	// get Supplier by id
	public Supplier getSupplierByID(int id);

	// get Supplier by name
	public Supplier getSupplierBYName(String name);

}
