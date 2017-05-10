package com.niit.backend.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="Category")
@Component
public class Category 
{
  @Id
  private String id;
  @Column(name="name")
  private String name;
  private String description;
  private Set<Product> products;
  @OneToMany(mappedBy="category",fetch=FetchType.EAGER)
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
  public Set<Product> getProducts() 
  {
	return products;
  }
  public void setProducts(Set<Product> products) 
  {
	this.products = products;
  }
}
