package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.ProviderByProductDAO;
import com.almacen.app.models.ProviderByProduct;

@RestController
public class ProviderByProductController {

	@Autowired
	private ProviderByProductDAO service;
	
	// http://localhost:8090/listProvByProduct

	@GetMapping("/listProvByProduct")
	public List<ProviderByProduct> provByProduct(){
		
		return service.list();
	}
	
}
