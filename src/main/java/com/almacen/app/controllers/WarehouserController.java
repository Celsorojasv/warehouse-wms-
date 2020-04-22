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

import com.almacen.app.DAO.WarehouseUserDAO;
import com.almacen.app.models.WarehouseUser;
import com.almacen.interfaces.IWarehouseUserService;

@RestController
public class WarehouserController {

	@Autowired
	private WarehouseUserDAO service;
	
	@Autowired
	private IWarehouseUserService service2;
	
	// http://localhost:8090/listWarehouseUsrs
	
	@GetMapping("/listWarehouseUsrs")
		public List<WarehouseUser> users(){
			return service.list();
		}
	
	// http://localhost:8090/createWarehouseUser (json  Body Raw JSON)
	
	@PostMapping(value = "/createWarehouseUser", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody WarehouseUser ware) {
		service2.createWareUser(ware);
		
		return "Created";
	}	
	
	// http://localhost:8090/updateWareUsr/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateWareUsr/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody WarehouseUser ware) {
		service2.updateWareUser(ware);
		return "Updated";
	}
	
	// http://localhost:8090/removeWareUsr/{id}
	
	@DeleteMapping("/removeWareUsr/{id}")
	public String removeWareUsr(@PathVariable Integer id) {
		service2.deleteWareUser(id);
		
		return "Deleted";
	}
	
	
}
