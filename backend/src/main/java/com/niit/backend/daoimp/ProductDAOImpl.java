package com.niit.backend.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired 
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public List<Product> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from product").list();
	}
	public boolean save(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(String id) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getProductByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Product getProductByID(String id) 
	{
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	public Product getProductByName(String name) 
	{
		return (Product) sessionFactory.getCurrentSession().createQuery("from product where name=?").setString(0, name).uniqueResult();
	}

}
