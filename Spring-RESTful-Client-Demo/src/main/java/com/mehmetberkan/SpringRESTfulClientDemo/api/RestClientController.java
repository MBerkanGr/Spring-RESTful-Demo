package com.mehmetberkan.SpringRESTfulClientDemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.mehmetberkan.SpringRESTfulClientDemo.entities.Product;

@Controller
@RequestMapping("/test")
public class RestClientController {
	
	private static final String webUrl = "http://localhost:8080/api";	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getAll() {
		ResponseEntity<List> results = restTemplate.getForEntity(webUrl+"/getall", List.class);
		List<Product> responseBody = results.getBody();
		return ResponseEntity.ok(responseBody);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> productgetById(@PathVariable int id) {
		ResponseEntity<Product> result =  restTemplate.getForEntity(webUrl+"/products/"+id, Product.class);
		return ResponseEntity.ok(result.getBody());
	}
	
	@PostMapping("/add")
	public void productAdd(@RequestBody Product product) {
		restTemplate.postForEntity(webUrl+"/add", product, Product.class);
	}
	
	@PostMapping("/update")
	public void productUpdate(@RequestBody Product product) { 
		restTemplate.postForEntity(webUrl+"/update", product, Product.class);
	}
	
	@PostMapping("/delete")
	public void productDelete(@RequestBody Product product) {
		restTemplate.postForEntity(webUrl+"/delete", product, Product.class);
	}
	
}
