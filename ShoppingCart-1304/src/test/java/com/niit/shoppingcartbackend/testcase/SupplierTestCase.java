/*package com.niit.shoppingcartbackend.testcase;
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	static SupplierDAO supplierDAO;
	
	
	
	// @BeforeClass it should be static

		@BeforeClass
		public static void init() {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.*");
			context.refresh();
			supplier = (Supplier) context.getBean("supplier");
			supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		}
		
		@Test
		public void saveSupplierTestCase() {
			supplier.setId("107");
			supplier.setName("abcd");
			supplier.setAddress("this is my address");
			boolean flag = supplierDAO.save(supplier);
			Assert.assertEquals("saveSupplierTestCase", true, flag);

		}
		public void updateSupplierTestCase() {
			supplier.setId("124");
			supplier.setName("kitty");
			supplier.setAddress("updating my description");
			boolean flag = supplierDAO.update(supplier);
			Assert.assertEquals("updateSupplierTestCase", true, flag);

		}
		
		 
		public void deleteSupplierTestCase() {
			supplier.setId("108");
			supplier.setName("noname");
			supplier.setAddress("deleting my usn number");
			boolean flag = supplierDAO.delete(supplier);
			Assert.assertEquals("deleteSupplierTestCase", true, flag);

		}
		
		public void deletebyidSupplierTestCase() {
			supplier.setId("108");
			// category.setName("kitty");
			supplier.setAddress("deleting my usn number by id");
			boolean flag = supplierDAO.delete(supplier);
			Assert.assertEquals("deletebyidSupplierTestCase", true, flag);
		}

	

}
*/