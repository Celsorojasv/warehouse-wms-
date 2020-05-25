package com.almacen.app.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"idOrderDetail","providerProduct","quantityIn","priceByProduct","totalOrder","order"})
public class OrderDetail {

	private Long idOrderDetail;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ProviderByProduct providerProduct;
	private Integer quantityIn;
	private Double priceByProduct;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Order order;
	
	
	
	public OrderDetail(Long idOrderDetail, ProviderByProduct providerProduct, Integer quantityIn, Double priceByProduct,
			Double totalOrder, Order order) {
		super();
		this.idOrderDetail = idOrderDetail;
		this.providerProduct = providerProduct;
		this.quantityIn = quantityIn;
		this.priceByProduct = priceByProduct;
		this.order = order;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(Long idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public ProviderByProduct getProviderProduct() {
		return providerProduct;
	}

	public void setProviderProduct(ProviderByProduct providerProduct) {
		this.providerProduct = providerProduct;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	
	
	
	
}
