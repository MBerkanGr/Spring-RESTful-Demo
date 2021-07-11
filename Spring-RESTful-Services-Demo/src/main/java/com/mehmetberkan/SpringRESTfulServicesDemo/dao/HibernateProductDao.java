package com.mehmetberkan.SpringRESTfulServicesDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mehmetberkan.SpringRESTfulServicesDemo.entities.Product;

@Repository
public class HibernateProductDao implements ProductDao{
	
	EntityManager entityManager;
	
	@Autowired
	public HibernateProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product", Product.class).getResultList();
		return products;
	}
	
	@Override
	@Transactional
	public Product getById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		Product product = session.get(Product.class, id);
		return product;
	}
	
	
	@Override
	@Transactional
	public void add(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void update(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
		
	}

	@Override
	@Transactional
	public void delete(Product product) {
		Session session = entityManager.unwrap(Session.class);
		Product willdeleProduct = session.get(Product.class, product.getId());
		session.delete(willdeleProduct);		
	}

	
}
