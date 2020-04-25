package com.almacen.app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DispatchByWarehouse {

	private Long idDispatchWarehouse;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Branch branch;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private WarehouseUser warehouseUser;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date lastSend;
	
	public DispatchByWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispatchByWarehouse(Long idDispatchWarehouse, Branch branch, WarehouseUser warehouseUser, Date lastSend) {
		super();
		this.idDispatchWarehouse = idDispatchWarehouse;
		this.branch = branch;
		this.warehouseUser = warehouseUser;
		this.lastSend = lastSend;
	}

	public Long getIdDispatchWarehouse() {
		return idDispatchWarehouse;
	}

	public void setIdDispatchWarehouse(Long idDispatchWarehouse) {
		this.idDispatchWarehouse = idDispatchWarehouse;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public WarehouseUser getWarehouseUser() {
		return warehouseUser;
	}

	public void setWarehouseUser(WarehouseUser warehouseUser) {
		this.warehouseUser = warehouseUser;
	}

	public Date getLastSend() {
		return lastSend;
	}

	public void setLastSend(Date lastSend) {
		this.lastSend = lastSend;
	}	
	
}
