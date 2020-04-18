package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.ProviderDAO;
import com.almacen.app.models.Provider;

@RestController
public class ProviderController {

	@Autowired
	private ProviderDAO service;
	
	// http://localhost:8090/listProvider
	
	@GetMapping ("/listProvider")
	public List<Provider> providers(){
		
		return service.list();
	}
}
