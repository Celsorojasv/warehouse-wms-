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

import com.almacen.app.DAO.OrderDAO;
import com.almacen.app.models.Order;
import com.almacen.interfaces.IOrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderDAO service;
	
	@Autowired
	private IOrderService service2;
	
	// http://localhost:8090/listOrders
	
	@GetMapping("/listOrders")
	public List<Order> orders(){
		return service.list();
	}
	
	// http://localhost:8090/createOrder 
	
	@PostMapping(value = "/createOrder", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody Order order) {
				
		service2.createOrder(order);
		
		return "Created";
	}	
	

	
	// http://localhost:8090/updateOrder/id 
	
	@PutMapping(value = "/updateOrder/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody Order order) {
		
		service2.updateOrder(order);
		
		return "Updated";
	}
	
	
	// http://localhost:8090/removeOrder/{id}
	
	@DeleteMapping("/removeOrder/{id}")
	public String removeWareUsr(@PathVariable Integer id) {
		service2.deleteOrder(id);
		
		return "Deleted";
	}
	
	
}

// http://localhost:8090/listOrders

// http://localhost:8090/createOrder 
/* CREATE
     {
        "dateTime": "2019-04-10",
        "totalAmount": 0.0
    }
*/

//http://localhost:8090/updateOrder/id 
/* UPDATE
{
   "idOrder": 501,
   "dateTime": "2019-04-10",
   "totalAmount": 0.0
}
*/

// http://localhost:8090/removeOrder/{id}

