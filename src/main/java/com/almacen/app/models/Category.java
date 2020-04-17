package com.almacen.app.models;

public class Category {

	private Long idCategory;
	private String nameCategory;
	private String descriptionCategory;
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(String nameCategory, String descriptionCategory) {
		super();
		this.nameCategory = nameCategory;
		this.descriptionCategory = descriptionCategory;
	}


	public Long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	public String getDescriptionCategory() {
		return descriptionCategory;
	}


	public void setDescriptionCategory(String descriptionCategory) {
		this.descriptionCategory = descriptionCategory;
	}

	
	
	
}
