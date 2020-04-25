package com.almacen.interfaces;

import com.almacen.app.models.DispatchByWarehouse;

public interface IDispatchByWarehouseService {

	public void createDetail(DispatchByWarehouse disWare);
	public void updateDetail(DispatchByWarehouse disWare);
	public void deleteDetail(Integer idDisWare);
}
