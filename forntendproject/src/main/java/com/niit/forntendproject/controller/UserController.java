package com.niit.forntendproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.User;

@Controller
public class UserController 
{
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired UserDAO userDAO;
	@Autowired User  user;
	@Autowired CategoryDAO categoryDAO;
	@Autowired  Category  category;
	@Autowired  HttpSession session;
	@PostMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, 
			@RequestParam("password") String password)
	{
		log.debug("Starting of the method login");
		
		log.info("You are login with the id "+id);
		ModelAndView mv = new ModelAndView("/home");
		 if(userDAO.validate(id, password)==true)
		 {
			 log.debug("Valid credentials");
			 
			 user = userDAO.get(id);
			 
			 //${message}  - to display in the Home.jsp
			 mv.addObject("message", " Welcom " + user.getName());
			 
			 mv.addObject("categoryList", categoryDAO.list());
			 mv.addObject("category", category);
			 
			 //check whether user is customer or admin
			 
			 if(user.getRole().equals("ROLE_ADMIN"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ROLE_ADMIN");
			 }
			 else
			 {
				 log.debug("You are customer");
				 mv.addObject("isAdmin", "false");
				 session.setAttribute("role", "ROLE_USER");
			 }
		 }
		 else
		 {
			 log.debug("Invalid user");
			 mv.addObject("message", "Invalid credentials..please try again.");
		 }
		 
		 log.debug("Ending of the method login");
		 return mv;
		
	}
	//We need to implement
	//create user
	//update user
	//getAllUsers
	//
}
