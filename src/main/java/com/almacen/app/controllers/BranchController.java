package com.almacen.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.app.DAO.BranchDAO;
import com.almacen.app.models.Branch;

@RestController
public class BranchController {

	@Autowired
	private BranchDAO service;

	@GetMapping("/listBranch")
	public List<Branch> branches() {
		
		return service.list();
	}

}
