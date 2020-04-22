package com.almacen.interfaces;

import com.almacen.app.models.Product;

public interface IProductService {
	
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Integer idProduct);

}
