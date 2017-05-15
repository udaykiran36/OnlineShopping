package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.domain.Category;

public class CategoryDAOTestCase
{
	@Autowired static AnnotationConfigApplicationContext context;
    @Autowired static CategoryDAO categoryDAO;
    @Autowired static Category category;
    @BeforeClass
    public static void init()
    {
 	   context = new AnnotationConfigApplicationContext();
 	   context.scan("com.niit");
 	   context.refresh();
 	   categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
 	   category = (Category) context.getBean("category");  
    }
	@Test
	public void createCategoryTestCase()
	{
		category.setId("BOOKS&MORE_001");
		category.setName("BOOKS&MORE");
		category.setDescription("Products Available");
		boolean flag = categoryDAO.save(category);
		assertEquals("create Category TestCase",true,flag);
	}
	/* @Test
	   public void updateCategoryTestCase()
	   {
			category.setId("Appliances_012");
			category.setName("Appliances");
			category.setDescription("All Appliances Products are Available");
			boolean flag = categoryDAO.save(category);
			assertEquals("update Category TestCase",true,flag);
	   }
	  @Test
	   public void deleteCategoryTestCase()
	   {
		
	   }
	   @Test
	   public void getAllCategoriesTestCase()
	   {
		   List<Category> categories = categoryDAO.list();
		   assertEquals(11,categories.size());
	   }*/

}
