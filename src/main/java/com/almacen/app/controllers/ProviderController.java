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

import com.almacen.app.DAO.ProviderDAO;
import com.almacen.app.models.Provider;
import com.almacen.interfaces.IProviderService;

@RestController
public class ProviderController {

	@Autowired
	private ProviderDAO service;
	
	@Autowired
	private IProviderService service2;
	
	// http://localhost:8090/listProvider
	
	@GetMapping ("/listProvider")
	public List<Provider> providers(){
		
		return service.list();
	}
	
	// http://localhost:8090/createProvider (json  Body Raw JSON)
	
	@PostMapping(value = "/createProvider", consumes = "application/json", produces = "application/json")
	public String addProvider(@RequestBody Provider provider) {
		service2.createProvider(provider);
		
		return "Created";
	}
	
	// http://localhost:8090/updateProvider/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateProvider/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateProvider(@PathVariable Integer id,@RequestBody Provider provider) {
		service2.updateProvider(provider);
		return "Updated";
	}
	
	// http://localhost:8090/removeProvider/{id}
	
	@DeleteMapping("/removeProvider/{id}")
	public String removeProvider(@PathVariable Integer id) {
		service2.deleteProvider(id);
		
		return "Deleted";
	}

}


// http://localhost:8090/listProvider


//http://localhost:8090/createProvider
/*CREATE
{
    "nameProvider": "Edgewire",
    "nitProvider": "696-60-4829",
    "phoneProvider": "517-956-3289",
    "addressProvider": "90350 Rowland Plaza"
}
*/


//http://localhost:8090/updateProvider/id 
/* UPDATE 
{
    "idProvider": 101,
    "nameProvider": "UPDATE TEST",
    "nitProvider": "696-60-4829",
    "phoneProvider": "517-956-3289",
    "addressProvider": "90350 Rowland Plaza"
}
*/


//http://localhost:8090/removeProvider/{id}