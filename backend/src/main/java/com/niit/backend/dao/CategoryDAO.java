package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.domain.Category;

public interface CategoryDAO 
{
	//get all categories -list
	public List<Category> list();
	//create category
	public boolean save(Category category);
	//update category
	public boolean update(Category category);
	//delete category
	public boolean delete(String id);
	//get category by id
	public Category getCategoryByID(String id);
	//get category by name
	public Category getCategoryByName(String name);
 
}
