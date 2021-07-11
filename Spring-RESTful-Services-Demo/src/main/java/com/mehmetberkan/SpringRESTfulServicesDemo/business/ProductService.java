package com.mehmetberkan.SpringRESTfulServicesDemo.business;

import java.util.List;

import com.mehmetberkan.SpringRESTfulServicesDemo.entities.Product;

public interface ProductService {
	List<Product> getAll();
	
	Product getById(int id);
	
	void add(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}
