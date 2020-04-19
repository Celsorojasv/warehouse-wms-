package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;

import com.almacen.app.models.Order;
import com.almacen.app.models.OrderDetail;
import com.almacen.app.models.ProviderByProduct;

@Service
public class OrderDetailDAO {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;


	 public List<OrderDetail> list(){
		 
		 
		 String sql = "SELECT * FROM order_detail";
		//Crear Vista para evitar los Nulls en el postman
		 
		 List<OrderDetail> listOrderDetail = jdbcTemplate.query(sql, new RowMapper<OrderDetail>() {

			@Override
			public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				OrderDetail or = new OrderDetail();
				Order order = new Order();
				ProviderByProduct py = new ProviderByProduct();
				
				or.setIdOrderDetail(rs.getLong("id_detail"));
				
				py.setIdProviderProduct(rs.getLong("id_provider_by_product"));				
				or.setIdProviderProduct(py);
				
				or.setQuantityIn(rs.getInt("quatity_in"));
				or.setPriceByProduct(rs.getDouble("price_by_product"));
				or.setTotalOrder(rs.getDouble("total_order"));
				
				order.setIdOrder(rs.getLong("id_order"));
				or.setIdOrder(order);
				
				return or;
			}
		 });
		 
		 return listOrderDetail;
	 }  
}
