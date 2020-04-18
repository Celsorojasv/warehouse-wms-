package com.almacen.app.models;

import java.util.Date;

public class Order {
	
	private Long idOrder;
	private Date dateTime;
	private Double totalAmount;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Order(Date dateTime, Double totalAmount) {
		super();
		this.dateTime = dateTime;
		this.totalAmount = totalAmount;
	}



	public Long getIdOrder() {
		return idOrder;
	}



	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}



	public Date getDateTime() {
		return dateTime;
	}



	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}



	public Double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
	

}
