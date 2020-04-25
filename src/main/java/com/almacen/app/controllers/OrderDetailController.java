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

import com.almacen.app.DAO.OrderDetailDAO;
import com.almacen.app.models.OrderDetail;
import com.almacen.interfaces.IOrderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	private OrderDetailDAO service;
	
	@Autowired
	private IOrderDetailService service2;
	
	// http://localhost:8090/listOrderDetail
	
	@GetMapping("/listOrderDetail")
	public List<OrderDetail> orderDetail(){
		return service.list();
	}

	// http://localhost:8090/createOrderDetail (json  Body Raw JSON)
	
	@PostMapping(value = "/createOrderDetail", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody OrderDetail Ordetail) {
		service2.createOrDetail(Ordetail);
		
		return "Created";
	}	
	
	
	// http://localhost:8090/updateOrderDetail/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateOrderDetail/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody OrderDetail Ordetail) {
		service2.updateOrDetail(Ordetail);
		return "Updated";
	}
	
	
	// http://localhost:8090/removeOrderDetail/{id}
	
	@DeleteMapping("/removeOrderDetail/{id}")
	public String removeWareUsr(@PathVariable Integer id) {
		service2.deleteOrDetail(id);
		
		return "Deleted";
	}


}



/*
 * { CREATE "providerProduct":{ "idProviderProduct":2 }, "quantityIn": 1000,
 * "priceByProduct": 1000.50, "totalOrder": 1000, "order":{ "idOrder":4 } }
 */

/*
 * { "idOrderDetail":1, "providerProduct":{ "idProviderProduct":2 },
 * "quantityIn": 1000, "priceByProduct": 2000.50, "totalOrder": 1000, "order":{
 * "idOrder":4 } }
 */



