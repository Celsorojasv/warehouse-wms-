package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.WarehouseUserDAO;
import com.almacen.app.models.WarehouseUser;

@RestController
public class WarehouserController {

	@Autowired
	private WarehouseUserDAO service;
	
	// http://localhost:8090/listWarehouseUsrs
	
	@GetMapping("/listWarehouseUsrs")
		public List<WarehouseUser> users(){
			return service.list();
		}
	}
