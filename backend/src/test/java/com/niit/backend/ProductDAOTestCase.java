package com.niit.backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.domain.Product;

public class ProductDAOTestCase
{
	@Autowired static AnnotationConfigApplicationContext context;
    @Autowired static ProductDAO productDAO;
    @Autowired static Product product;
    @BeforeClass
    public static void init()
    {
 	   context = new AnnotationConfigApplicationContext();
 	   context.scan("com.niit");
 	   context.refresh();
 	   productDAO = (ProductDAO) context.getBean("productDAO");
 	   product = (Product) context.getBean("product");
    }
	@Test
	public void createProductTestCase()
	{
		product.setId("ELEC_001");
		product.setCategoryID("ELECTRONICS_001");
		product.setDescription("MOTO Mobile");
		product.setName("Moto G5");
		product.setPrice(16000);
		product.setSupplierID("SP_Reliance_001");
		boolean flag = productDAO.save(product);
		assertEquals("create Product TestCase",true,flag);
	}
	/* @Test
	   public void updateCategoryTestCase()
	   {
			product.setId("");
			product.setName("");
			product.setDescription("");
			product.setCategoryID("");
			product.setPrice(1000);
			product.setSupplierID("");
			boolean flag = productDAO.save(product);
			assertEquals("update Product TestCase",true,flag);
	   }
	  @Test
	   public void deleteCategoryTestCase()
	   {
		
	   }
	   @Test
	   public void getAllCategoriesTestCase()
	   {
		   List<Product> categories = productDAO.list();
		   assertEquals(11,categories.size());
	   }*/
}
