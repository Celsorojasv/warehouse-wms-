package com.almacen.app.models;


public class Branch{
	
	
	private Long idBranch;
	private String nameBranch;
	private String addressBranch;
	private String phoneBranch;
	

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Branch(String nameBranch, String addressBranch, String phoneBranch) {
		super();
		this.nameBranch = nameBranch;
		this.addressBranch = addressBranch;
		this.phoneBranch = phoneBranch;
	}


	public Long getIdBranch() {
		return idBranch;
	}


	public void setIdBranch(Long idBranch) {
		this.idBranch = idBranch;
	}


	public String getNameBranch() {
		return nameBranch;
	}


	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
	}


	public String getAddressBranch() {
		return addressBranch;
	}


	public void setAddressBranch(String addressBranch) {
		this.addressBranch = addressBranch;
	}


	public String getPhoneBranch() {
		return phoneBranch;
	}


	public void setPhoneBranch(String phoneBranch) {
		this.phoneBranch = phoneBranch;
	}


	
	
}
