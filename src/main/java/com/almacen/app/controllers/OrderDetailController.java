package com.almacen.app.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.OrderDetailDAO;
import com.almacen.app.models.OrderDetail;

@RestController
public class OrderDetailController {

	@Autowired
	private OrderDetailDAO service;
	
	// http://localhost:8090/listOrderDetail
	
	@GetMapping("/listOrderDetail")
	public List<OrderDetail> orderDetail(){
		return service.list();
	}
}
