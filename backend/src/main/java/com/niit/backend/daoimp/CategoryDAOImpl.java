package com.niit.backend.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired 
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public List<Category> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from category").list();
	}

	@Override
	public boolean save(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().save(category);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String id)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Category getCategoryByID(String id)
	{
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public Category getCategoryByName(String name)
	{
		return (Category) sessionFactory.getCurrentSession().createQuery("from category where name=?").setString(0,name).uniqueResult();
	}

}
