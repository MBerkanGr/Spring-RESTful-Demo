package com.mehmetberkan.SpringRESTfulServicesDemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetberkan.SpringRESTfulServicesDemo.business.ProductService;
import com.mehmetberkan.SpringRESTfulServicesDemo.entities.Product;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")
	public List<Product> getAll(){
		return this.productService.getAll();
	}

	@PostMapping("/add")
	public void addProduct(@RequestBody Product product) {
		this.productService.add(product);
	}
	
	@PostMapping("/update")
	public void updateProduct(@RequestBody Product product) {
		this.productService.update(product);
	}
	
	@PostMapping("/delete")
	public void deleteProduct(@RequestBody Product product) {
		this.productService.delete(product);
	}
	
	@GetMapping("/products/{id}")
	public Product getById(@PathVariable int id) {
		return this.productService.getById(id);
	}
	
	
	
	
}
