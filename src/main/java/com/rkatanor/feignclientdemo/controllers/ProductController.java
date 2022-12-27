package com.rkatanor.feignclientdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkatanor.feignclientdemo.model.Product;
import com.rkatanor.feignclientdemo.util.FeignUtility;

@RestController
public class ProductController {

	@Autowired
	FeignUtility feignUtility;

	public static final String PRODUCT_SERVICE = "productService";

	@GetMapping(value = "/getproducts")
	public ResponseEntity<List<Product>> getAllProductsData() {
		return feignUtility.getAllProducts();
	}



}
