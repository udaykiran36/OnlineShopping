package com.niit.forntendproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;

@Controller

public class HomeController
{
    @Autowired HttpSession session;
	
	@Autowired  Category category;
	
	@Autowired  CategoryDAO  categoryDAO;
	
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	@RequestMapping( value ={"/","/home","/index" })
	
	public ModelAndView home()
	{
		 ModelAndView mv=new ModelAndView("home");
		 List<Category>  categoryList =  categoryDAO.list();
		 session.setAttribute("categoryList", categoryList);
		 session.setAttribute("category", category);
			
		 session.setAttribute("product", product);
		 session.setAttribute("productList", productDAO.list());
		 return mv;
		 
	}
	@RequestMapping( value ={"/login"})
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	@RequestMapping( value ={"/registration"})
	public ModelAndView registration()
	{
		ModelAndView mv=new ModelAndView("registration");
		return mv;
	}
}
