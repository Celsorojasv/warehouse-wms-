package com.almacen.interfaces;

import com.almacen.app.models.ProviderByProduct;

public interface IProviderByProductService {

	public void createProByProd(ProviderByProduct ProByP);
	public void updateProByProd(ProviderByProduct ProByP);
	public void deleteProByProd(Integer idProByP);

	
}
