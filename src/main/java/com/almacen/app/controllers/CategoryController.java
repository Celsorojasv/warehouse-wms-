package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.CategoryDAO;
import com.almacen.app.models.Category;
import com.almacen.interfaces.ICategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryDAO service;
	
	@Autowired
	private ICategoryService service2;
	
	// http://localhost:8090/listCategory
	
	@GetMapping("/listCategory")
	public List<Category> categories(){
		
		return service.list();
	}
	
	// http://localhost:8090/createCategory
	
	@PostMapping(value = "/createCategory", consumes = "application/json", produces = "application/json")
	public String addCategory(@RequestBody Category category) {
		service2.createCategory(category);
		
		return "Created";
	}
	
	// http://localhost:8090/updateCategory/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateCategory/{id}", consumes = "application/json", produces = "application/json" )
	public String updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		service2.updateCategory(category);
		return "Updated";

	}
	
	// http://localhost:8090/removeCategory/{id}
	
	@DeleteMapping("/removeCategory/{id}")
	public String removeCategory(@PathVariable Integer id) {
		service2.deleteCategory(id);
		
		return "Deleted";
	}
	
}
