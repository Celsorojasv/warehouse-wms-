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

import com.almacen.app.DAO.DispatchDetailDAO;
import com.almacen.app.models.DispatchDetail;
import com.almacen.interfaces.IDispatchDetailsService;

@RestController
public class DispatchDetailController {

	@Autowired
	private DispatchDetailDAO service;
	
	@Autowired
	private IDispatchDetailsService service2;
	
	// http://localhost:8090/listDispatchDetail
	
	@GetMapping("/listDispatchDetail")
	public List<DispatchDetail> dispatchDetail(){
		return service.list();
	}
	
	// http://localhost:8090/createDispatchDetail 
	
	@PostMapping(value = "/createDispatchDetail", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody DispatchDetail detail) {
		
		System.out.println(detail.toString());
		
		service2.createDetail(detail);
		
		return "Created";
	}	
	

	
	// http://localhost:8090/updateDispatchDetail/id  
	
	@PutMapping(value = "/updateDispatchDetail/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody DispatchDetail detail) {
		
		service2.updateDetail(detail);
		
		return "Updated";
	}
	
	
	// http://localhost:8090/removeDispatchDetail/{id}
	
	@DeleteMapping("/removeDispatchDetail/{id}")
	public String removeWareUsr(@PathVariable Integer id) {
		service2.deleteDetail(id);
		
		return "Deleted";
	}
	
}

// http://localhost:8090/listDispatchDetail



// http://localhost:8090/createDispatchDetail 
/* CREATE
    {
        "dispatchWarehouse": {
            "idDispatchWarehouse": 210
        },
        "quantityOut": 100,
        "providerProduct": {
            "idProviderProduct": 778
        }
    }
*/

//http://localhost:8090/updateDispatchDetail/id  
/* UPDATE
{
    "id": 1,
    "dispatchWarehouse": {
        "idDispatchWarehouse": 210
    },
    "quantityOut": 100,
    "providerProduct": {
        "idProviderProduct": 778
    }
}
*/

//http://localhost:8090/removeDispatchDetail/{id}

