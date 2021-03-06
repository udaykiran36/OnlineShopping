package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

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
		product.setId("Elec_Pdt_003");
		product.setCategory_ID("ELECTRONICS_002");
		product.setName("IPHONE 6S");
		product.setDescription("IPHONE Mobile");
		product.setPrice(8000);
		product.setSupplier_ID("SP_Reliance_001");
		product.setQuantity(1);
		boolean flag = productDAO.saveOrupdate(product);
		assertEquals("create Product TestCase",true,flag);
	}
	/*@Test
	public void updateCategoryTestCase()
	{
		product.setId("");
		product.setName("");
		product.setDescription("");
		product.setCategoryID("");
		product.setPrice(1000);
		product.setSupplierID("");
		proudect.setQuantity(4);
		boolean flag = productDAO.saveOrupdate(product);
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
