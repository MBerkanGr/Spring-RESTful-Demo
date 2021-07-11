package com.mehmetberkan.SpringRESTfulServicesDemo.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmetberkan.SpringRESTfulServicesDemo.dao.ProductDao;
import com.mehmetberkan.SpringRESTfulServicesDemo.entities.Product;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	@Transactional
	public List<Product> getAll() {
		return this.productDao.getAll();
	}
	
	@Override
	public Product getById(int id) {
		return this.productDao.getById(id);
	}


	@Override
	@Transactional
	public void add(Product product) {
		this.productDao.add(product);	
	}

	@Override
	@Transactional
	public void update(Product product) {
		this.productDao.update(product);	
	}

	@Override
	@Transactional
	public void delete(Product product) {
		this.productDao.delete(product);	
	}

	
}
