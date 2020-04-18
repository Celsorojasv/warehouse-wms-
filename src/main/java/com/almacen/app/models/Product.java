package com.almacen.app.models;

import java.util.Date;

public class Product {
	
	private Long idProduct;
	private String nameProduct;
	private Date createdProduct;
	private Category idCategory;
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String nameProduct, Date createdProduct, Category idCategory) {
		super();
		this.nameProduct = nameProduct;
		this.createdProduct = createdProduct;
		this.idCategory = idCategory;
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



	public Category getIdCategory() {
		return idCategory;
	}



	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}

	


}
