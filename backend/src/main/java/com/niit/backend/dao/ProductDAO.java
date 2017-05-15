package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.domain.Product;

public interface ProductDAO
{
	 public List<Product> list();
	 public boolean save(Product product);
	 public boolean update(Product product);
	 public boolean delete(String id);
	 public Product getProductByID(String id);
	 public Product getProductByName(String name);
}
