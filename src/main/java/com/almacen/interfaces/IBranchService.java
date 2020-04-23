package com.almacen.interfaces;

import com.almacen.app.models.Branch;

public interface IBranchService {
	
	public void createBranch(Branch branch);
	public void updateBranch(Branch branch);
	public void deleteBranch(Integer idBranch);

}

