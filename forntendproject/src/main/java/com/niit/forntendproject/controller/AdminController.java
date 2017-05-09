package com.niit.forntendproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.domain.Category;

@Controller
public class AdminController 
{
 private static Logger log = LoggerFactory.getLogger(AdminController.class);
 @Autowired HttpSession session;
 @Autowired Category category;
 @Autowired CategoryDAO categoryDAO;
 @RequestMapping("/manageCategories")
	 public ModelAndView manageCategories()
		{
			
			log.debug("Starting of the method manageCategories");
			
			ModelAndView mv = new ModelAndView("Home");
			if(session.getAttribute("logedInUserID")==null)
			{
				mv.addObject("message", "Pleaes login to do this controller");
				return mv;
			}
			if(! session.getAttribute("role").equals("ROLE_ADMIN"))
			{
				mv.addObject("message", "You are not admin. You cannot perform this operation");
				return mv;
			}
			mv.addObject("isAdminClickedCategories", "true");
			mv.addObject("isAdmin", "true");
			
			log.debug("End of the method manageCategories");
			return mv;
			
			
		}
		@RequestMapping("/manageSupplier")
		public ModelAndView manageSuppliers()
		{
			log.debug("Starting of the method manageSuppliers");
			ModelAndView mv = new ModelAndView("Home");
			mv.addObject("isAdmin", "true");
			mv.addObject("isAdminClickedSuppliers", "true");
			log.debug("Ending of the method manageSuppliers");
			return mv;
			
			
		}
		@RequestMapping("/manageProducts")
		public ModelAndView manageProducts()
		{
			log.debug("Starting of the method manageProducts");
			
			ModelAndView mv = new ModelAndView("Home");
			mv.addObject("isAdmin", "true");
			mv.addObject("isAdminClickedProducts", "true");
			log.debug("Ending of the method manageProducts");
			return mv;	

		}
 }

