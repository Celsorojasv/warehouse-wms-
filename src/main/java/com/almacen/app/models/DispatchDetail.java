package com.almacen.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"culo","dispatchWarehouse","quantityOut","providerProduct"})
public class DispatchDetail {

	@JsonProperty("culo") // Alias Json Convencion todo minuscula. 
	private Long idDispatch;
	private DispatchByWarehouse dispatchWarehouse;
	private Integer quantityOut;
	private ProviderByProduct providerProduct;
	
	public DispatchDetail() {
		super();
		// TODO Auto-generated constructor stub
		

	}

	public DispatchDetail(Long idDispatch, DispatchByWarehouse dispatchWarehouse, Integer quantityOut,
			ProviderByProduct providerProduct) {
		super();
		this.idDispatch = idDispatch;
		this.dispatchWarehouse = dispatchWarehouse;
		this.quantityOut = quantityOut;
		this.providerProduct = providerProduct;
	}

	public Long getIdDispatch() {
		return idDispatch;
	}

	public void setIdDispatch(Long idDispatch) {
		this.idDispatch = idDispatch;
	}

	public DispatchByWarehouse getDispatchWarehouse() {
		return dispatchWarehouse;
	}

	public void setDispatchWarehouse(DispatchByWarehouse dispatchWarehouse) {
		this.dispatchWarehouse = dispatchWarehouse;
	}

	public Integer getQuantityOut() {
		return quantityOut;
	}

	public void setQuantityOut(Integer quantityOut) {
		this.quantityOut = quantityOut;
	}

	public ProviderByProduct getProviderProduct() {
		return providerProduct;
	}

	public void setProviderProduct(ProviderByProduct providerProduct) {
		this.providerProduct = providerProduct;
	}


	
	
}
