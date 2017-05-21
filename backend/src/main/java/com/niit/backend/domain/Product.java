package com.niit.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
	private int quantity;
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
	@Transient
	private MultipartFile image;
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
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String getCategory_ID()
	{
		return category_ID;
	}
	public void setCategory_ID(String category_ID)
	{
		this.category_ID = category_ID;
	}
	public String getSupplier_ID()
	{
		return supplier_ID;
	}
	public void setSupplier_ID(String supplier_ID)
	{
		this.supplier_ID = supplier_ID;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public Supplier getSupplier()
	{
		return supplier;
	}
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}
	public MultipartFile getImage()
	{
		return image;
	}
	public void setImage(MultipartFile image)
	{
		this.image = image;
	}
	
	
}
