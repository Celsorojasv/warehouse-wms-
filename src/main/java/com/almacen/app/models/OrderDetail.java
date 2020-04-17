package com.almacen.app.models;

public class OrderDetail {

	private Long idOrder;
	private ProviderByProduct idProviderProduct;
	private Integer quantityIn;
	private Double priceByProduct;
	private Double totalOrder;
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(ProviderByProduct idProviderProduct, Integer quantityIn, Double priceByProduct,
			Double totalOrder) {
		super();
		this.idProviderProduct = idProviderProduct;
		this.quantityIn = quantityIn;
		this.priceByProduct = priceByProduct;
		this.totalOrder = totalOrder;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public ProviderByProduct getIdProviderProduct() {
		return idProviderProduct;
	}

	public void setIdProviderProduct(ProviderByProduct idProviderProduct) {
		this.idProviderProduct = idProviderProduct;
	}

	public Integer getQuantityIn() {
		return quantityIn;
	}

	public void setQuantityIn(Integer quantityIn) {
		this.quantityIn = quantityIn;
	}

	public Double getPriceByProduct() {
		return priceByProduct;
	}

	public void setPriceByProduct(Double priceByProduct) {
		this.priceByProduct = priceByProduct;
	}

	public Double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(Double totalOrder) {
		this.totalOrder = totalOrder;
	}
	
	
	
	
}
