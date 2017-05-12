package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.domain.Supplier;

public interface SupplierDAO
{
	public List<Supplier> list();
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(String id);
	public Supplier getSupplierByID(String id);
	public Supplier getSupplierByName(String name);
}
