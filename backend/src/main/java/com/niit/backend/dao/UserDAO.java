package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.domain.User;

public interface UserDAO 
{
  //create/register -save
  public boolean save(User user);
  //update the user details -update
  public boolean update(User user);
  //validate the credentials -validate
  public boolean validate(String id, String password);
  //get all users -list
  public List<User> list();
  //get user details based on userID
  public User get(String id);
}
