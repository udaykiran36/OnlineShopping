package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.domain.Category;
import com.niit.backend.domain.Product;

public interface ProductDAO 
{
  //get all product -list
  public List<Product> list();
  //create product
  public boolean save(Product product);
  //update product
  public boolean update(Product product);
  //delete product
  public boolean delete(String id);
  //get product by id
  public Product getProductByID(String id);
  //get category by name
  public Product getProductByName(String name);
  public List<Category> getAllProductsByCategoryID(String id);
  public List<Product> getSimilarProducts(String search_string);
}
