package com.almacen.app.models;

import java.util.Date;

public class DispatchByWarehouse {

	private Long idDispatchWarehouse;
	private Branch idBranch;
	private WarehouseUser idUser;
	private Date lastSend;
	
	public DispatchByWarehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispatchByWarehouse(Branch idBranch, WarehouseUser idUser, Date lastSend) {
		super();
		this.idBranch = idBranch;
		this.idUser = idUser;
		this.lastSend = lastSend;
	}

	public Long getDispatchWarehouse() {
		return idDispatchWarehouse;
	}

	public void setDispatchWarehouse(Long dispatchWarehouse) {
		this.idDispatchWarehouse = dispatchWarehouse;
	}

	public Branch getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(Branch idBranch) {
		this.idBranch = idBranch;
	}

	public WarehouseUser getIdUser() {
		return idUser;
	}

	public void setIdUser(WarehouseUser idUser) {
		this.idUser = idUser;
	}

	public Date getLastSend() {
		return lastSend;
	}

	public void setLastSend(Date lastSend) {
		this.lastSend = lastSend;
	}
	
	
	
}
