package com.almacen.app.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Product {
	
	private Long idProduct;
	private String nameProduct;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdProduct;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Category category;
	

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long idProduct, String nameProduct, Date createdProduct, Category category) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.createdProduct = createdProduct;
		this.category = category;
	}
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public Date getCreatedProduct() {
		return createdProduct;
	}
	public void setCreatedProduct(Date createdProduct) {
		this.createdProduct = createdProduct;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	




}
