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

import com.almacen.app.DAO.BranchDAO;
import com.almacen.app.models.Branch;
import com.almacen.interfaces.IBranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchDAO service;
	
	@Autowired
	private IBranchService service2;

	// http://localhost:8090/listBranch
	
	@GetMapping("/listBranch")
	public List<Branch> branches() {
		
		return service.list();
	}


	// http://localhost:8090/createBranch (json  Body Raw JSON)
	
	@PostMapping(value = "/createBranch", consumes = "application/json", produces = "application/json")
	public String addBranch(@RequestBody Branch branch) {
		service2.createBranch(branch);
		
		return "Created";
	}
	
	// http://localhost:8090/updateBranch/id  (json  Body Raw JSON)
	
	@PutMapping(value = "/updateBranch/{id}" , consumes = "application/json", produces = "application/json") 
	public String updateBranch(@PathVariable Integer id,@RequestBody Branch branch) {
		service2.updateBranch(branch);
		return "Updated";
	}
	
	// http://localhost:8090/removeBranch/{id}
	
	@DeleteMapping("/removeBranch/{id}")
	public String removeBranch(@PathVariable Integer id) {
		service2.deleteBranch(id);
		
		return "Deleted";
	}
	
}


// http://localhost:8090/listBranch


// http://localhost:8090/createBranch 

/*
    {
        "nameBranch": "TEST1-Lesch",
        "addressBranch": "6 Dawn Center",
        "phoneBranch": "548-757-1014"
    }

*/


// http://localhost:8090/removeBranch/{id}

/*
*
    {
        "idBranch": 447,
        "nameBranch": "TEST UPDATE",
        "addressBranch": "6 Dawn Center",
        "phoneBranch": "548-757-1014"
    }
*/

// http://localhost:8090/removeBranch/{id}






