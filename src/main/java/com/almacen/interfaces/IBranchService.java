package com.almacen.interfaces;

import com.almacen.app.models.Branch;

public interface IBranchService {
	
	public void deleteBranch(Integer idBranch);
	public void updateBranch(Branch branch);
	public void createBranch(Branch branch);
}
