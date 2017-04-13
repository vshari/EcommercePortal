package com.niit.shoppingcart.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class ProductController {

	// category.jsp -addCategory,deleteCategory, showCatrgoryList,
	// updateCategory,editCategory
	// to get all categories from database

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	@Autowired
	private Supplier supplier;

	@Autowired(required = true)
	private SupplierDAO suppilerDAO;
	@Autowired
	private Category category;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	/*
	 * public ModelAndView getAllCategories() { ModelAndView mv = new
	 * ModelAndView("/AdminHome"); List<Category> categoryList =
	 * categoryDAO.list(); mv.addObject("categoryList", categoryList);
	 * mv.addObject("isUserClickedCategory", true); return mv; }
	 */
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts() {
		List<Product> products = productDAO.list();
		return new ModelAndView("Product", "productList", products);
	}

	// Methd 1- Create

	@RequestMapping(value = "/manage_product_create", method = RequestMethod.GET)
	public ModelAndView createProduct() {
		System.out.println("inside the  Product method");
		ModelAndView mv = new ModelAndView("ProductForm");
		mv.addObject("createProductObj", product);
		mv.addObject("productList", this.productDAO.list());
		mv.addObject("category", new Category());
		mv.addObject("categoryList", this.categoryDAO.list());
		mv.addObject("supplier", new Supplier());
		mv.addObject("supplierList", this.suppilerDAO.list());
		return mv;
	}
	// Method 2 create

	@RequestMapping(value = "/manage_product_create", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute(value = "createProductObj") Product product, MultipartFile file,
			Model model, BindingResult result) {

		System.out.println(" method called create product");
		// ModelAndView mv = new ModelAndView("/Admin/Product");
		// mv.addObject("isUserClickedProducts","true");
		if (result.hasErrors())
			return "ProductForm";

		Category category = categoryDAO.getCategoryBYName(product.getCategory().getName());
		System.out.println(category.getId() + ":" + category.getName() + ":" + category.getDescription());

		Supplier supplier = suppilerDAO.getSupplierBYName(product.getSupplier().getName());
		System.out.println(supplier.getId() + ":" + supplier.getName() + ":" + supplier.getAddress());

		product.setCategory(category);
		product.setSupplier(supplier);

		productDAO.save(product);
		
		MultipartFile prodImage = product.getImage();
		System.out.println(prodImage);
		if (prodImage != null || !prodImage.isEmpty()) {
			// to store this image
			Path paths = Paths.get("D:/deep/ShoppingCart/src/main/webapp/WEB-INF/resources/images/"
					+ product.getId() + ".png");
			try {
				prodImage.transferTo(new File(paths.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/getAllProducts";

		/*
		 * if (categoryDAO.save(category)) { mv.addObject("message",
		 * "seccessfully created the category"); List<Category> categoryList =
		 * categoryDAO.list(); mv.addObject("categoryList", categoryList);
		 * mv.addObject("category", category); } else { mv.addObject("message",
		 * "Not able to create Cateory. please contact Adminstrator"); } return
		 * mv;
		 * 
		 * 
		 */
	}

	@RequestMapping(value = "/manage_product_delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "id") int id, Model model) {
		System.out.println("delete product");
		Product product = productDAO.getProductByID(id);
		productDAO.delete(product);
		return "redirect:/getAllProducts";
		/*
		 * public String deleteProduct(@PathVariable("id") String id)
		 * 
		 * { ModelAndView mv = new ModelAndView("/Admin/Product"); Product
		 * product = (Product) productDAO.getProductByID(id); if
		 * (productDAO.delete(product)) { mv.addObject("message",
		 * "Successfuly deleted the Product"); List<Product> productList =
		 * productDAO.list(); mv.addObject("productList", productList);
		 * mv.addObject("product", product); } else { mv.addObject("message",
		 * "Not able to delete the Product so please contact adminstrator"); }
		 * return "redirect:/getAllProducts"; // return mv;
		 */ }
	// Edit Method 1

	// @GetMapping(value = "manage_product_edit/{id}")
	@RequestMapping(value = "manage_product_edit/{id}", method = RequestMethod.GET)
	public ModelAndView getEditProduct(@PathVariable(value = "id") int id, HttpServletRequest request) {
		System.out.println("edit method called");
		ModelAndView mv = new ModelAndView("/ProductEditForm");

		Product product = productDAO.getProductByID(id);
		mv.addObject("productEditForm", product);

		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		mv.addObject("category", category);

		List<Supplier> supplierList = suppilerDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier", supplier);

		return mv;
	}

	@PostMapping("manage_product_edit/{id}")
	public String editProduct(@ModelAttribute(value = "productEditForm") Product product) {
		System.out.println("Edit product");
		productDAO.update(product);
		return "redirect:/getAllProducts";
		/*
		 * ModelAndView mv = new ModelAndView("/Admin/Product"); if
		 * (productDAO.update(product)) { mv.addObject("message", "edited");
		 * List<Product> productList = productDAO.list();
		 * mv.addObject("productList", productList); mv.addObject("product",
		 * product);
		 * 
		 * } else { mv.addObject("message", "fail to edit");
		 * 
		 * }
		 */

		// return mv;
	}

}
