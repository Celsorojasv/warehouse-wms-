package com.almacen.interfaces;

import com.almacen.app.models.Order;

public interface IOrderService {

	public void createOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Integer idOrder);
	
}
