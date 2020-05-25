package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.almacen.app.models.Order;
import com.almacen.app.models.OrderDetail;
import com.almacen.app.models.ProviderByProduct;
import com.almacen.interfaces.IOrderDetailService;

@Service
public class OrderDetailDAO  implements IOrderDetailService {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 private SimpleJdbcCall call;


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
				or.setProviderProduct(py);
				
				or.setQuantityIn(rs.getInt("quatity_in"));
				or.setPriceByProduct(rs.getDouble("price_by_product"));
				
				order.setIdOrder(rs.getLong("id_order"));
				or.setOrder(order);
				
				return or;
			}
		 });
		 
		 return listOrderDetail;
	 }


	@Override
	public void createOrDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		// pid_provider_by_product,pquatity_in,pprice_by_product,ptotal_order,pid_order		

		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_order_detail");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_provider_by_product", orderDetail.getProviderProduct().getIdProviderProduct());
		map.put("pquatity_in", orderDetail.getQuantityIn());
		map.put("pprice_by_product", orderDetail.getPriceByProduct());
		map.put("pid_order", orderDetail.getOrder().getIdOrder());

		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}


	@Override
	public void updateOrDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		// pid_detail,pid_provider_by_product,pquatity_in,pprice_by_product,ptotal_order,pid_order		

		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_order_detail");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_detail", orderDetail.getIdOrderDetail());
		map.put("pid_provider_by_product", orderDetail.getProviderProduct().getIdProviderProduct());
		map.put("pquatity_in", orderDetail.getQuantityIn());
		map.put("pprice_by_product", orderDetail.getPriceByProduct());
		map.put("pid_order", orderDetail.getOrder().getIdOrder());

		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
		
	}


	@Override
	public void deleteOrDetail(Integer idOrderDetail) {
		// TODO Auto-generated method stub
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_order_detail");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_detail", idOrderDetail);
		
		call.execute(src);
	}		
	
}
