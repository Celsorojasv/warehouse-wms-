package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.OrderDAO;
import com.almacen.app.models.Order;

@RestController
public class OrderController {

	@Autowired
	private OrderDAO service;
	
	// http://localhost:8090/listOrders
	
	@GetMapping("/listOrders")
	public List<Order> orders(){
		return service.list();
	}
	
}


