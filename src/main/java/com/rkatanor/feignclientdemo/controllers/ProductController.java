package com.rkatanor.feignclientdemo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rkatanor.feignclientdemo.model.Product;
import com.rkatanor.feignclientdemo.util.FeignUtility;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.vavr.collection.Stream;

@RestController
public class ProductController {

	@Autowired
	FeignUtility feignUtility;

	public static final String PRODUCT_SERVICE = "productService";

	@GetMapping(value = "/getproducts")
	@Retry(name = PRODUCT_SERVICE, fallbackMethod = "getAvailableProducts")
	public ResponseEntity<List<Product>> getAllProductsData() {
		return feignUtility.getAllProducts();
	}

	public ResponseEntity<List<Product>> getAvailableProducts(Exception e) {
		Product p1 = new Product();
		p1.setId(600);
		p1.setProductName("Iphone");
		p1.setProduct_price(987);
		p1.setProductType("Mobile");
		p1.setProduct_desc("Iphone XS 256GB");

		Product p2 = new Product();
		p2.setId(600);
		p2.setProductName("Google");
		p2.setProduct_price(1007);
		p2.setProductType("Mobile");
		p2.setProduct_desc("Google XL 256GB");
		
		List<Product> produtList=new ArrayList<>();
		produtList.add(p1);
		produtList.add(p2);
		
		return new ResponseEntity<List<Product>>(produtList, HttpStatus.OK);
	}

}
