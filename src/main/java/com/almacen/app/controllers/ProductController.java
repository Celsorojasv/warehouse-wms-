package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.models.Product;
import com.almacen.app.DAO.ProductDAO;

@RestController
public class ProductController {

	@Autowired
	private ProductDAO service;
	
	// http://localhost:8090/listProduct
	
	@GetMapping("/listProduct")
	public List<Product> products(){
		
		return service.list();
	}
}
