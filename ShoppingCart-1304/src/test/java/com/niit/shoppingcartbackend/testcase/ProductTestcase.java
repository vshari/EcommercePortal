/*
 * package com.niit.shoppingcartbackend.testcase;
 * 
 * import static org.junit.Assert.*;
 * 
 * import java.util.List;
 * 
 * import org.junit.BeforeClass; import org.junit.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.AnnotationConfigApplicationContext;
 * 
 * import com.niit.shoppingcart.dao.CategoryDAO; import
 * com.niit.shoppingcart.dao.ProductDAO; import
 * com.niit.shoppingcart.domain.Category; import
 * com.niit.shoppingcart.domain.Product;
 * 
 * import junit.framework.Assert;
 * 
 * public class ProductTestcase {
 * 
 * @Autowired private static Product product;
 * 
 * @Autowired static ProductDAO productDAO;
 * 
 * // @BeforeClass it should be static
 * 
 * @BeforeClass public static void init() { AnnotationConfigApplicationContext
 * context = new AnnotationConfigApplicationContext();
 * context.scan("com.niit.*"); context.refresh(); product = (Product)
 * context.getBean("product"); productDAO = (ProductDAO)
 * context.getBean("productDAO");
 * 
 * } // WRITE TEST CASES we required test cases for create,update,delete and //
 * create new category
 * 
 * @Test public void saveCategoryTestCase() { product.setId("999");
 * product.setName("abcd"); product.setPrice("1100");
 * product.setCategory_id("05"); product.setSupplier_id("555"); boolean flag =
 * productDAO.save(product); Assert.assertEquals("saveProductTestCase", true,
 * flag);
 * 
 * }
 * 
 * public void updateProductTestCase() { product.setId("124");
 * product.setName("kitty"); product.setPrice("updating my description");
 * boolean flag = productDAO.update(product);
 * Assert.assertEquals("updateProductTestCase", true, flag);
 * 
 * }
 * 
 * 
 * public void deleteProductTestCase() { product.setId("108");
 * product.setName("noname"); product.setPrice("deleting my usn number");
 * boolean flag = productDAO.delete(product);
 * Assert.assertEquals("deleteProductTestCase", true, flag);
 * 
 * }
 * 
 * public void deletebyidProductTestCase() { product.setId("108"); //
 * category.setName("kitty"); product.setPrice("deleting my usn number by id");
 * boolean flag = productDAO.delete(product);
 * Assert.assertEquals("deletebyidProductTestCase", true, flag); }
 * 
 * 
 * 
 * }
 * 
 */