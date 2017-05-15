package com.niit.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")
@Component
public class Product implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	@Column(name="name")
	private String name;
	private String description;
	private int price;
	private String category_ID;
	private String supplier_ID;
	@ManyToOne
	@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false, updatable = false, insertable = false)
      //  @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    //    @JoinColumn(name = "supplier_id")
	private Supplier supplier;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public String getCategory_ID()
	{
		return category_ID;
	}
	public void setCategory_ID(String categoryID)
	{
		this.category_ID = category_ID;
	}
	public String getSupplier_ID()
	{
		return supplier_ID;
	}
	public void setSupplier_ID(String supplierID)
	{
		this.supplier_ID = supplier_ID;
	}
	
}
