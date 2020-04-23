package com.almacen.interfaces;

import com.almacen.app.models.OrderDetail;

public interface IOrderDetailService {
	
	public void createOrDetail(OrderDetail orderDetail);
	public void updateOrDetail(OrderDetail orderDetail);
	public void deleteOrDetail(Integer idOrderDetail);

}
