package com.niit.forntendproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.domain.Product;
import com.niit.backend.domain.Supplier;

@Controller
public class SupplierController
{
	private static  Logger log = LoggerFactory.getLogger(SupplierController.class);
	//create suppliers
	//fetch all suppliers
	//delete suppliers
	//update suppliers
		@Autowired  SupplierDAO supplierDAO;
		@Autowired  Supplier supplier;	
		@Autowired  ProductDAO productDAO;	
		@Autowired  Product product;
		@Autowired  HttpSession session;
		//@RequestMapping("/manage_suppliers_add")
		@GetMapping("/manage_supplier_add")
		public ModelAndView  createSupplier(@RequestParam("id") String id, 
				@RequestParam("name") String name,  @RequestParam("address") String add)
		{	
			log.debug("Starting of the method manageSuppliers");
			supplier.setId(id);
			supplier.setName(name);
			supplier.setAddress(add);	
			ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");		
			mv.addObject("isAdminClickedSuppliers", "true");
			mv.addObject("isAdmin", "true");		
			//Before calling save method, check whether the supplier id already exist in db or not	
			//if it is does not exist, then only call save method	
			if (supplierDAO.getSupplierByID(id) !=null)
			{
				//supplier already exist
				mv.addObject("message", "Supplier already exist with teh id " +id);
				return mv;
				
			}
			else  // actualy else is not required if return statement is there in if condition
			{
				supplierDAO.save(supplier);
				mv.addObject("message", "Supplier created successfuly ");
			}
			/*session.setAttribute("supplierList", supplierDAO.list());
			session.setAttribute("supplier", supplier);*/
			log.debug("End of the method manageSuppliers");
			return mv;
		}
		@GetMapping("/manage_supplier_delete/{id}")
		public ModelAndView deleteSupplier(@PathVariable("id") String id)
		{
			log.debug("Starting of the method deleteSupplier");
			log.debug("You are going to delete " + id);
			ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
			//check whether products are there for this supplier or not
			int size = productDAO.getAllProductsByCategoryID(id).size();
			if(size!=0)
			{
				log.debug("Few products are there under this supplier. you can not delete");
				 mv.addObject("message", size+ " products are there under supplier" + id +". you can not delete");
				 session.setAttribute("message", size+ " products are there under supplier" + id +". you can not delete");
				 return mv;
			}
			 if( supplierDAO.delete(id))
			 {
				 mv.addObject("message", "successfully deleted the supplier");
			 }
			 else
			 {
				 mv.addObject("message", "Not able to delte the supplier");
			 }
				/*session.setAttribute("supplierList", supplierDAO.list());
				session.setAttribute("supplier", supplier);*/
				log.debug("Ending of the method deleteSupplier");	 
			 return mv;	
		}
		//http://localhost:8080/ShoppingCartFrontEnd/manage_supplier_edit/cat001
		@RequestMapping("/manage_supplier_edit/{id}")
		public ModelAndView editSupplier(@PathVariable("id") String id )
		{		
			log.debug("Starting of the method editSupplier");	
			log.debug("Going to edit the supplier : " + id);
			 supplier=  supplierDAO.getSupplierByID(id);
			 //selected supplier details we have to store in another instance
			 // in ModelAndView instance	 
			 ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
			 session.setAttribute("selectedSuppliers", supplier);
			 mv.addObject("selectedSuppliers", supplier);
			 log.debug("Ending of the method editSuppliers");
			 return mv;
		}
		//@GetMapping("/maage_supplier_edit/manage_supplier_update")
		@PostMapping("/manage_supplier_update")
		public ModelAndView  updateSupplier(@RequestParam("id") String id, 
				@RequestParam("name") String name,  @RequestParam("address") String add)
		{
			
			log.debug("Starting of the method updateSupplier");
			supplier.setId(id);
			supplier.setName(name);
			supplier.setAddress(add);
			
			ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
			
			/*mv.addObject("isAdminClickedSuppliers", "true");
			mv.addObject("isAdmin", "true");*/
			
			//Before calling save method, check whether the supplier id already exist in db or not
			
			//if it is does not exist, then only call save method
			
			if (supplierDAO.getSupplierByID(id) ==null)
			{
				//supplier does not exist
				mv.addObject("message", "Supplier does now exist with the id " +id);
				return mv;
				
			}
			else  // actualy else is not required if return statement is there in if condition
			{
				supplierDAO.update(supplier);
				mv.addObject("message", "Supplier update successfuly ");
			}
			log.debug("End of the method updateSupplier");
			
			return mv;
		}

}
