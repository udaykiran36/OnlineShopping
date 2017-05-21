package com.niit.backend.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
	@Override
	public List<Product> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from product").list();
	}
	@Override
	public boolean saveOrupdate(Product product)
	{
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} 
		catch (Exception e)
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
			sessionFactory.getCurrentSession().delete(getProductByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Product getProductByID(String id)
	{
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public Product getProductByName(String name)
	{
		return (Product) sessionFactory.getCurrentSession().createQuery("from product where name=?").setString(0, name).uniqueResult();
	}
	@Override
	public List<Product> getAllProductsByCategoryID(String categoryID)
	{
		Query query=	sessionFactory.getCurrentSession().createQuery("from Product where categoryID=?");
		query.setString(0, categoryID);
		
	    return	query.list();
	}
	
	@Override
	public List<Product> getAllProductsBySupplierId(String supplierId)
	{
		return sessionFactory.getCurrentSession().createQuery("from Product where supplier_Id = ?").setString(0, supplierId).list();
	}
}
