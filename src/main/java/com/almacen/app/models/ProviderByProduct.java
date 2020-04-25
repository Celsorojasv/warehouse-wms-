package com.almacen.app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ProviderByProduct {
	
	private Long idProviderProduct;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastAdded;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Provider provider;   
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Product product;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private WarehouseUser wUser;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer quantity;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double priceProduct;
	

	public ProviderByProduct() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProviderByProduct(Long idProviderProduct, Date lastAdded, Provider provider, Product product,
			WarehouseUser wUser, Integer quantity, Double priceProduct) {
		super();
		this.idProviderProduct = idProviderProduct;
		this.lastAdded = lastAdded;
		this.provider = provider;
		this.product = product;
		this.wUser = wUser;
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


	public Provider getProvider() {
		return provider;
	}


	public void setProvider(Provider provider) {
		this.provider = provider;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public WarehouseUser getwUser() {
		return wUser;
	}


	public void setwUser(WarehouseUser wUser) {
		this.wUser = wUser;
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
