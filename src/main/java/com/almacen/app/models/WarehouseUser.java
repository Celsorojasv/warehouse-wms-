package com.almacen.app.models;

public class WarehouseUser {
	
	private Long idUser;
	private String nameUser;
	private String phoneUser;
	private String jobTitle;
	

	public WarehouseUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public WarehouseUser(String nameUser, String phoneUser, String jobTitle) {
		super();
		this.nameUser = nameUser;
		this.phoneUser = phoneUser;
		this.jobTitle = jobTitle;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public String getPhoneUser() {
		return phoneUser;
	}


	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	
	
	

}
