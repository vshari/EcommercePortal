package com.niit.shoppingcart.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {

	@Autowired
	HttpSession session;

	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;
	// To display registration form
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		ModelAndView mv = new ModelAndView("/registration");
		mv.addObject("isUserClickedRegister", "true");
		mv.addObject("user", user);
		return mv;

	}

	// To post registration form
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String doRegistraton(@Valid @ModelAttribute(value = "user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}
		model.addAttribute("registrationSuccessMessage", "Registered Successfully. Login using username and password");
		model.addAttribute("userObject", user);

		userDAO.save(user);
		return "login";

	}

	@RequestMapping("/validate")

	public ModelAndView validateCredentials(@RequestParam("userName") String name,

			@RequestParam("password") String pwd)

	{

		// Actually you have to get the data from database

		// temp user->niit password = niit@123

		ModelAndView mv = new ModelAndView("/home");
		// march 8th below line
		mv.addObject("isUserLoggedIn", "false");

		// if (id.equals("niit") && pwd.equals("niit@123"))
		if (userDAO.validate(name, pwd) == true)

		{
			// mv.addObject("msg", "Welcome to Shopping Cart");-->march 8th TL
			mv.addObject("isUserLoggedIn", "true");
			user = userDAO.getUserByName(name);
			if (user.getRole().equals("ROLE_ADMIN")) {
				mv.addObject("isAdmin", "true");
			}

			else {
				mv.addObject("isAdmin", "false");
			}
			mv.addObject("successMessage", "Valid Credentials");

			session.setAttribute("loginMessage", "Welcome :" + name);

		}

		else

		{

			mv.addObject("errorMessage", "InValid Credentials , please try again ");

		}

		return mv;

	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("error", "Invalid username and password... Please enter the correctly");
		if (logout != null)
			model.addAttribute("logout", "logout successfully");

		return "login";
	}

}