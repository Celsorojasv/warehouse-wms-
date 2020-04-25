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
import com.almacen.interfaces.IOrderService;

@Service
public class OrderDAO implements IOrderService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;

	public List<Order> list() {

		String sql = "SELECT * FROM N_ORDER";

		List<Order> listOrder = jdbcTemplate.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				Order o = new Order();

				o.setIdOrder(rs.getLong("id_order"));
				o.setDateTime(rs.getDate("date_time"));
				o.setTotalAmount(rs.getDouble("total_amount"));

				return o;
			}
		});
		return listOrder;
	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		// pdate_time,ptotal_amount 
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_n_order");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pdate_time",order.getDateTime());
		map.put("ptotal_amount",order.getTotalAmount());
		
				SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		// pid_order,pdate_time,ptotal_amount 
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_n_order");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_order",order.getIdOrder());
		map.put("pdate_time",order.getDateTime());
		map.put("ptotal_amount",order.getTotalAmount());
		
				SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);

		
	}

	@Override
	public void deleteOrder(Integer IdOrder) {
		// TODO Auto-generated method stub delete_n_order
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_n_order");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_order", IdOrder);
		
		call.execute(src);
		
	}
}

