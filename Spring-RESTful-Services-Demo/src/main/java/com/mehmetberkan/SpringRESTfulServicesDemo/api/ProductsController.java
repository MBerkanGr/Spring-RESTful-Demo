package com.mehmetberkan.SpringRESTfulServicesDemo.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetberkan.SpringRESTfulServicesDemo.business.ProductService;

@RestController
@RequestMapping("/api")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/")
	public String get() {
		return "computer";
	}
	
	@GetMapping("/getall")
	public Object[] getAllProducts() {
		return Arrays.asList("Desktop","Keyboard","Stand").stream().toArray();
	}

}
