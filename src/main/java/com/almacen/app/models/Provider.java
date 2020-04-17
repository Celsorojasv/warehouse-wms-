package com.almacen.app.models;

public class Provider {
	
	private Long idProvider;
	private String nameProvider;
	private String nitProvider;
	private String phoneProvider;
	private String addressProvider;
	


	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Provider(String nameProvider, String nitProvider, String phoneProvider, String addressProvider) {
		super();
		this.nameProvider = nameProvider;
		this.nitProvider = nitProvider;
		this.phoneProvider = phoneProvider;
		this.addressProvider = addressProvider;
	}



	public Long getIdProvider() {
		return idProvider;
	}



	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}



	public String getNameProvider() {
		return nameProvider;
	}



	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}



	public String getNitProvider() {
		return nitProvider;
	}



	public void setNitProvider(String nitProvider) {
		this.nitProvider = nitProvider;
	}



	public String getPhoneProvider() {
		return phoneProvider;
	}



	public void setPhoneProvider(String phoneProvider) {
		this.phoneProvider = phoneProvider;
	}



	public String getAddressProvider() {
		return addressProvider;
	}



	public void setAddressProvider(String addressProvider) {
		this.addressProvider = addressProvider;
	}

	

}
