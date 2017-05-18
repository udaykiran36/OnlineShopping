package com.niit.forntendproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController
{
	private static  Logger log = LoggerFactory.getLogger(AdminController.class);
	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories()
	{
		log.debug("Starting of the method manageCategories");
		ModelAndView mv = new ModelAndView("admin/category");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		log.debug("End of the method manageCategories");
		return mv;
	}
	@RequestMapping("/manageSupplier")
	public ModelAndView manageSuppliers()
	{
		log.debug("Starting of the method manageSuppliers");
		ModelAndView mv = new ModelAndView("admin/supplier");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedSuppliers", "true");
		log.debug("Ending of the method manageSuppliers");
		return mv;
	}
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts()
	{
		log.debug("Starting of the method manageProducts");
		ModelAndView mv = new ModelAndView("admin/product");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedProducts", "true");
		log.debug("Ending of the method manageProducts");
		return mv;
	}
}
