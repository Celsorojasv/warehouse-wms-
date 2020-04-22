package com.almacen.interfaces;

import com.almacen.app.models.WarehouseUser;

public interface IWarehouseUserService {

	public void createWareUser(WarehouseUser ware);
	public void updateWareUser(WarehouseUser ware);
	public void deleteWareUser(Integer idWarehouseUser);
}
