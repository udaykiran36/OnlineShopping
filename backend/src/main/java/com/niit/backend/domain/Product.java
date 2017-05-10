package com.niit.backend.domain;

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
public class Product 
{
  @Id
  private String id;
  @Column(name="name")
  private String name;
  private String description;
  private int price;
  private String categoryID;
  private String supplierID;
  @ManyToOne
  @JoinColumn(name="category_id", updatable = false, insertable = false, nullable = false)
  private Category category;
  @ManyToOne
  @JoinColumn(name="supplier_id", updatable = false, insertable = false, nullable = false)
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
  public String getCategoryID() 
  {
	return categoryID;
  }
  public void setCategoryID(String categoryID) 
  {
	this.categoryID = categoryID;
  }
  public String getSupplierID() 
  {
	return supplierID;
  }
  public void setSupplierID(String supplierID) 
  {
	this.supplierID = supplierID;
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
