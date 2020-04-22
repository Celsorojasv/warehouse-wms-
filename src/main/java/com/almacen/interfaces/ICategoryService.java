package com.almacen.interfaces;

import com.almacen.app.models.Category;

public interface ICategoryService {

	public void createCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Integer idCategory);

}
