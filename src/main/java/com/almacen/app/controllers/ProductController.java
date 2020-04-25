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

import com.almacen.app.models.Product;
import com.almacen.interfaces.IProductService;
import com.almacen.app.DAO.ProductDAO;

@RestController
public class ProductController {

	@Autowired
	private ProductDAO service;
	
	@Autowired
	private IProductService service2;
	
	// http://localhost:8090/listProduct
	
	@GetMapping("/listProduct")
	public List<Product> products(){
		
		return service.list();
	}
	
	// http://localhost:8090/createProduct

	
	@PostMapping(value = "/createProduct" , consumes = "application/json", produces = "application/json")
	public String addProduct(@RequestBody Product product) {
		service2.createProduct(product);
		return "Added";
	}
	
	// http://localhost:8090/updateProduct/id  (json  Body Raw JSON)

	
	@PutMapping(value = "/updateProduct/{id}" , consumes = "application/json", produces = "application/json")
	public String updateProduct(@PathVariable Integer id,@RequestBody Product product) {
		service2.updateProduct(product);
		return "Updated";
	}
	
	// http://localhost:8090/removeProduct/{id}

	
	@DeleteMapping("/removeProduct/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		service2.deleteProduct(id);
		return "Deleted";
	}
	
}

/* CREATE
 * { "nameProduct": "PIZZA", "createdProduct": "2012-04-23 25:43:51,
 * "category":{ "idCategory":1 } }
 */


/* UPDATE
 * { "idProduct":2 ,"nameProduct": "PIZZA", "createdProduct": "2012-04-23 25:43:51,
 * "category":{ "idCategory":1 } }
 */

