package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.domain.User;

public class UserDAOTestCase
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired  static UserDAO  userDAO;
	@Autowired  static User user;
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	@Test
	public void createUserTestCase() 
	{
		user.setId("ADMIN");
		user.setContact("8899661234");
		user.setName("ADMIN");
		user.setPassword("udaybk");
		user.setRole("ROLE_ADMIN");
		boolean flag = userDAO.save(user);
		assertEquals("createUser TestCase",true,flag);
	}
	/*
	@Test
	public void updateUserTestCase()
	{
		user.setId("ADMIN");
		user.setContact("8899776633");
		user.setName("kiran");
		user.setPassword("udayk");
		user.setRole("ROLE_USER");
		boolean flag = userDAO.update(user);
		assertEquals("update User TestCase",true,flag);
	}
	@Test
	public void validateUserTestCase()
	{
		
		boolean flag =  userDAO.validate("kiran", "udayk");
		
		
		assertEquals(true, flag);
		
	}
 
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(12, actualSize);
	}*/
}
