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

import com.almacen.app.DAO.ProviderByProductDAO;
import com.almacen.app.models.ProviderByProduct;
import com.almacen.interfaces.IProviderByProductService;

@RestController
public class ProviderByProductController {

	@Autowired
	private ProviderByProductDAO service;
	
	@Autowired
	private IProviderByProductService service2;
	
	// http://localhost:8090/listProvByProduct

	@GetMapping("/listProvByProduct")
	public List<ProviderByProduct> provByProduct(){
		
		return service.list();
	}
	// http://localhost:8090/createProByP 
	
	@PostMapping(value = "/createProByP", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody ProviderByProduct ProByP) {
		
		service2.createProByProd(ProByP);
		
		return "Created";
	}	
	

	
	// http://localhost:8090/updateProByP/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateProByP/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody ProviderByProduct ProByP) {
		
		service2.updateProByProd(ProByP);
		
		return "Updated";
	}
	
	
	// http://localhost:8090/removeProByP/{id}
	
	@DeleteMapping("/removeProByP/{id}")
	public String removeWareUsr(@PathVariable Integer id) {
		service2.deleteProByProd(id);
		
		return "Deleted";
	}
	
}
