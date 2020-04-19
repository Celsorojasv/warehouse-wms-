package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.DispatchDetailDAO;
import com.almacen.app.models.DispatchDetail;

@RestController
public class DispatchDetailController {

	@Autowired
	private DispatchDetailDAO service;
	
	// http://localhost:8090/listDispatchDetail
	
	@GetMapping("/listDispatchDetail")
	public List<DispatchDetail> dispatchDetail(){
		return service.list();
	}
	
}
