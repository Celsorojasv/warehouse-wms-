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

import com.almacen.app.DAO.DispatchByWarehouseDAO;
import com.almacen.app.models.DispatchByWarehouse;
import com.almacen.interfaces.IDispatchByWarehouseService;

@RestController
public class DispatchByWarehouseController {
	
	@Autowired
	private DispatchByWarehouseDAO service;
	
	@Autowired
	private IDispatchByWarehouseService service2;
	
	// http://localhost:8090/listDisByWare
	
	@GetMapping("/listDisByWare")
	public List<DispatchByWarehouse> warehouse(){
		return service.list();
	}
	
	// http://localhost:8090/createDisByWare 
	
	@PostMapping(value = "/createDisByWare", consumes = "application/json", produces = "application/json")
	public String addWareUsr(@RequestBody DispatchByWarehouse DisByWare) {
		
		
		service2.createDetail(DisByWare);
		
		return "Created";
	}	
	
	// http://localhost:8090/updateDisByWare/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateDisByWare/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateWareUsr(@PathVariable Integer id,@RequestBody DispatchByWarehouse DisByWare) {
		
		service2.updateDetail(DisByWare);
		
		return "Updated";
	}
	
	// http://localhost:8090/removeDisByWare/id
	
	@DeleteMapping("/removeDisByWare/{id}")
	public String remove(@PathVariable Integer id) {
		service2.deleteDetail(id);
		
		return "Deleted";
	}

}


// http://localhost:8090/listDisByWare


// http://localhost:8090/createDisByWare 
/* CREATE
     {
        "branch": {
            "idBranch": 196
        },
        "warehouseUser": {
            "idUser": 8
        },
        "lastSend": "2019-08-05"
    }
 */


// http://localhost:8090/updateDisByWare/id
/* UPDATE
{
   "idDispatchWarehouse": 501,
   "branch": {
       "idBranch": 196
   },
   "warehouseUser": {
       "idUser": 8
   },
   "lastSend": "2019-08-05"
}
*/

// http://localhost:8090/removeDisByWare/id
