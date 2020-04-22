package com.almacen.interfaces;

import com.almacen.app.models.Provider;

public interface IProviderService {
	
	public void createProvider(Provider provider);
	public void updateProvider(Provider provider);
	public void deleteProvider(Integer idProvider);
	
}
