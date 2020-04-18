package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.CategoryDAO;
import com.almacen.app.models.Category;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryDAO service;
	
	// http://localhost:8090/listCategory
	
	@GetMapping("/listCategory")
	public List<Category> categories(){
		
		return service.list();
	}
	
	

}
