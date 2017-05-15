package com.niit.forntendproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class HomeController
{
	@RequestMapping( value ={"/","/home","/index" })
	
	public ModelAndView home()
	{
		 ModelAndView mv=new ModelAndView("home");
		 return mv;
		 
	}
	@RequestMapping( value ={"/login"})
		public String myLoginPage()
		{
			
			
			return "login";
	}
	@RequestMapping( value ={"/registration"})
	public ModelAndView registration()
	{
		ModelAndView mv=new ModelAndView("registration");
		return mv;
	}
}
