package com.niit.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name ="User")	//if the table name domain class name is different
@Component
public class User 
{
  @Id  		//we have mention which one is primary key
  private String id;
  @Column(name="name")	//if the field name in table & property name in class is different
  private String name;
  //@Min(5)
  //@Max(15)
  private String password;
  private String contact;
  private String role;
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
  public String getPassword() 
  {
	return password;
  }
  public void setPassword(String password) 
  {
	this.password = password;
  }
  public String getContact() 
  {
	return contact;
  }
  public void setContact(String contact) 
  {
	this.contact = contact;
  }
  public String getRole() 
  {
	return role;
  }
  public void setRole(String role) 
  {
	this.role = role;
  }
  
}
