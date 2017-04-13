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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {

	// supplier.jsp -addSupplier,deleteSupplier, showCatrgoryList,
	// updateSupplier,editSupplier
	// to get all categories from database

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	/*
	 * public ModelAndView getAllCategories() { ModelAndView mv = new
	 * ModelAndView("/AdminHome"); List<Supplier> supplierList =
	 * supplierDAO.list(); mv.addObject("supplierList", supplierList);
	 * mv.addObject("isUserClickedSupplier", true); return mv; }
	 */
	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers() {
		List<Supplier> suppliers = supplierDAO.list();
		return new ModelAndView("Supplier", "supplierList", suppliers);
	}

	@RequestMapping(value = "/manage_supplier_create", method = RequestMethod.GET)
	public ModelAndView createSupplier() {
		System.out.println("inside the supplier method");
		ModelAndView mv = new ModelAndView("/SupplierForm");
		mv.addObject("createSupplierObj", supplier);
		return mv;
	}

	@RequestMapping(value = "/manage_supplier_create", method = RequestMethod.POST)
	public String createSupplier(@ModelAttribute("createSupplierObj") Supplier supplier) {

		supplierDAO.save(supplier);

		return "redirect:/getAllSuppliers";

		/*
		 * if (supplierDAO.save(supplier)) { mv.addObject("message",
		 * "seccessfully created the supplier"); List<Supplier> supplierList =
		 * supplierDAO.list(); mv.addObject("supplierList", supplierList);
		 * mv.addObject("supplier", supplier); } else { mv.addObject("message",
		 * "Not able to create Cateory. please contact Adminstrator"); } return
		 * mv;
		 * 
		 * 
		 */
	}

	@RequestMapping("/manage_supplier_delete/{id}")
	public String deleteSupplier(@PathVariable("id") int id)

	{
		ModelAndView mv = new ModelAndView("/Supplier");
		Supplier supplier = (Supplier) supplierDAO.getSupplierByID(id);
		if (supplierDAO.delete(supplier)) {
			mv.addObject("message", "Successfuly deleted the supplier");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);
			mv.addObject("supplier", supplier);
		} else {
			mv.addObject("message", "Not able to delete the supplier so please contact adminstrator");
		}
		return "redirect:/getAllSuppliers";
		// return mv;
	}

	@GetMapping(value = "manage_supplier_edit/{id}")
	public ModelAndView getEditSupplier(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("/SupplierEditForm");
		Supplier supplier = (Supplier) supplierDAO.getSupplierByID(id);
		mv.addObject("supplierEditForm", supplier);
		return mv;
	}

	@PostMapping("manage_supplier_edit/{id}")
	public String editSupplier(@ModelAttribute(value = "supplierEditForm") Supplier supplier) {
		System.out.println("Edit supplier");
		ModelAndView mv = new ModelAndView("/Supplier");
		if (supplierDAO.update(supplier)) {
			mv.addObject("message", "edited");
			List<Supplier> supplierList = supplierDAO.list();
			mv.addObject("supplierList", supplierList);
			mv.addObject("supplier", supplier);

		} else {
			mv.addObject("message", "fail to edit");

		}
		return "redirect:/getAllSuppliers";
		// return mv;
	}

}
