package com.almacen.app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DispatchByWarehouse {

	private Long idDispatchWarehouse;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Branch idBranch;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private WarehouseUser idUser;
	@JsonInclude(JsonInclude.Include.NON_NULL)
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

	public Long getIdDispatchWarehouse() {
		return idDispatchWarehouse;
	}

	public void setIdDispatchWarehouse(Long dispatchWarehouse) {
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

	@Override
	public String toString() {
		return "DispatchByWarehouse [idDispatchWarehouse=" + idDispatchWarehouse + ", idBranch=" + idBranch
				+ ", idUser=" + idUser + ", lastSend=" + lastSend + "]";
	}
	
	
	
}
