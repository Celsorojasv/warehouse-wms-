package com.almacen.app.models;

public class DispatchDetail {

	private Long idDispatch;
	private DispatchByWarehouse idDispatchWarehouse;
	private Integer quantityOut;
	private ProviderByProduct idProviderProduct;
	
	public DispatchDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DispatchDetail(DispatchByWarehouse idDispatchWarehouse, Integer quantityOut,
			ProviderByProduct idProviderProduct) {
		super();
		this.idDispatchWarehouse = idDispatchWarehouse;
		this.quantityOut = quantityOut;
		this.idProviderProduct = idProviderProduct;
	}

	public Long getIdDispatch() {
		return idDispatch;
	}

	public void setIdDispatch(Long idDispatch) {
		this.idDispatch = idDispatch;
	}

	public DispatchByWarehouse getIdDispatchWarehouse() {
		return idDispatchWarehouse;
	}

	public void setIdDispatchWarehouse(DispatchByWarehouse idDispatchWarehouse) {
		this.idDispatchWarehouse = idDispatchWarehouse;
	}

	public Integer getQuantityOut() {
		return quantityOut;
	}

	public void setQuantityOut(Integer quantityOut) {
		this.quantityOut = quantityOut;
	}

	public ProviderByProduct getIdProviderProduct() {
		return idProviderProduct;
	}

	public void setIdProviderProduct(ProviderByProduct idProviderProduct) {
		this.idProviderProduct = idProviderProduct;
	}
	
	
}
