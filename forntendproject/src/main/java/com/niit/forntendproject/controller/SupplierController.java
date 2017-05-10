package com.niit.forntendproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;

@Controller
public class SupplierController 
{
	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired  SupplierDAO supplierdAO;
	@Autowired  Supplier supplier;
    @Autowired  ProductDAO productDAO;
	@Autowired  Product product;
	@Autowired  HttpSession session;
	@GetMapping("/manage_supplier_add")
	public ModelAndView  createSupplier(@RequestParam("id") String id, 
			@RequestParam("name") String name,  @RequestParam("address") String add)
	{
		
		log.debug("Starting of the method manageCategories");
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(add);
		
		ModelAndView mv = new ModelAndView("redirect:/manageSupplier");
		
		mv.addObject("isAdminClickedSupplier", "true");
		mv.addObject("isAdmin", "true");
		
		//Before calling save method, check whether the category id already exist in db or not
		
		//if it is does not exist, then only call save method
		
		if (supplierdAO.getSupplierByID(id) !=null)
		{
			//category already exist
			mv.addObject("message", "Supplier already exist with teh id " +id);
			return mv;
			
		}
		else  // actualy else is not required if return statement is there in if condition
		{
			supplierdAO.save(supplier);
			mv.addObject("message", "Supplier created successfuly ");
		}
		
		
		/*session.setAttribute("categoryList", categorydAO.list());
		session.setAttribute("category", category);*/
		
		log.debug("End of the method manageSupplier");
		
		return mv;	
	}
}
