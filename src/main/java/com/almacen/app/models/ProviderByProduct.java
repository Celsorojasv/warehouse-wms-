package com.almacen.app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ProviderByProduct {
	
	private Long idProviderProduct;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date lastAdded;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Provider idProvider;   
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Product idProduct;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private WarehouseUser idUser;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer quantity;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double priceProduct;
	

	public ProviderByProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProviderByProduct(Date lastAdded, Provider idProvider, Product idProduct, WarehouseUser idUser,
			Integer quantity, Double priceProduct) {
		super();
		this.lastAdded = lastAdded;
		this.idProvider = idProvider;
		this.idProduct = idProduct;
		this.idUser = idUser;
		this.quantity = quantity;
		this.priceProduct = priceProduct;
	}


	public Long getIdProviderProduct() {
		return idProviderProduct;
	}


	public void setIdProviderProduct(Long idProviderProduct) {
		this.idProviderProduct = idProviderProduct;
	}


	public Date getLastAdded() {
		return lastAdded;
	}


	public void setLastAdded(Date lastAdded) {
		this.lastAdded = lastAdded;
	}


	public Provider getIdProvider() {
		return idProvider;
	}


	public void setIdProvider(Provider idProvider) {
		this.idProvider = idProvider;
	}


	public Product getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}


	public WarehouseUser getIdUser() {
		return idUser;
	}


	public void setIdUser(WarehouseUser idUser) {
		this.idUser = idUser;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPriceProduct() {
		return priceProduct;
	}


	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	

	
	
	
}
