package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.DispatchByWarehouseDAO;
import com.almacen.app.models.DispatchByWarehouse;

@RestController
public class DispatchByWarehouseController {
	
	@Autowired
	private DispatchByWarehouseDAO service;
	
	// http://localhost:8090/listDisByWare
	
	@GetMapping("/listDisByWare")
	public List<DispatchByWarehouse> warehouse(){
		return service.list();
	}
	

}
