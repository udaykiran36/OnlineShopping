package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.domain.Category;
import com.niit.backend.domain.Supplier;

public class SupplierDAOTestCase 
{
	@Autowired static AnnotationConfigApplicationContext context;
	 @Autowired static SupplierDAO supplierDAO;
	 @Autowired static Supplier supplier;
	 @BeforeClass
	 public static void init()
	 {
		 context = new AnnotationConfigApplicationContext();
		 context.scan("com.niit");
		 context.refresh();
		 supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		 supplier = (Supplier) context.getBean("supplier");
	 }
	@Test
	public void createSupplierTestCase() 
	{
		supplier.setId("SP_Reliance_001");
		supplier.setName("pradeep");
		supplier.setAddress("Hyderabad");
		boolean flag = supplierDAO.save(supplier);
		assertEquals("create Supplier TestCase",true,flag);
	}
	 /*@Test
	   public void updateSupplierTestCase()
	   {
			supplier.setId("Appliances_012");
			supplier.setName("Appliances");
			supplier.setAddress("");
			boolean flag = supplierDAO.save(supplier);
			assertEquals("update Supplier TestCase",true,flag);
	   }
	  @Test
	   public void deleteSupplierTestCase()
	   {
		
	   }
	   @Test
	   public void getAllSupplierTestCase()
	   {
		   List<Supplier> categories = supplierDAO.list();
		   assertEquals(11,categories.size());
	   }*/
}
