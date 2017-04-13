package com.niit.shoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {

	// category.jsp -addCategory,deleteCategory, showCatrgoryList,
	// updateCategory,editCategory
	// to get all categories from database

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	/*
	 * public ModelAndView getAllCategories() { ModelAndView mv = new
	 * ModelAndView("/AdminHome"); List<Category> categoryList =
	 * categoryDAO.list(); mv.addObject("categoryList", categoryList);
	 * mv.addObject("isUserClickedCategory", true); return mv; }
	 */
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories() {
		List<Category> categories = categoryDAO.list();
		return new ModelAndView("Category", "categoryList", categories);
	}

	@RequestMapping(value = "/manage_category_create", method = RequestMethod.GET)
	public ModelAndView createCategory() {
		System.out.println("inside the category method");
		ModelAndView mv = new ModelAndView("/CategoryForm");
		mv.addObject("createCategoryObj", category);
		return mv;
	}

	@RequestMapping(value = "/manage_category_create", method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("createCategoryObj") Category category) {

		categoryDAO.save(category);

		return "redirect:/getAllCategories";

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

	@RequestMapping("/manage_category_delete/{id}")
	public String deleteCategory(@PathVariable("id") int id)

	{
		ModelAndView mv = new ModelAndView("/Category");
	
		Category category = (Category) categoryDAO.getCategoryByID(id);
				if (categoryDAO.delete(category)) {
			mv.addObject("message", "Successfuly deleted the category");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);
			mv.addObject("category", category);
		} else {
			mv.addObject("message", "Not able to delete the category so please contact adminstrator");
		}
		return "redirect:/getAllCategories";
		// return mv;
	}

	@GetMapping(value = "manage_category_edit/{id}")
	public ModelAndView getEditCategory(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/CategoryEditForm");
		Category category = (Category) categoryDAO.getCategoryByID(id);
		mv.addObject("categoryEditForm", category);
		return mv;
	}

	@PostMapping("manage_category_edit/{id}")
	public String editCategory(@ModelAttribute(value = "categoryEditForm") Category category) {
		System.out.println("Edit category");
		ModelAndView mv = new ModelAndView("/Category");
		if (categoryDAO.update(category)) {
			mv.addObject("message", "edited");
			List<Category> categoryList = categoryDAO.list();
			mv.addObject("categoryList", categoryList);
			mv.addObject("category", category);

		} else {
			mv.addObject("message", "fail to edit");

		}
		return "redirect:/getAllCategories";
	}

}
