package com.rkatanor.feignclientdemo.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.rkatanor.feignclientdemo.model.Product;



@FeignClient(name = "feignDemo",url = "http://localhost:8080/api/v2")
public interface FeignUtility {
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts();

}
