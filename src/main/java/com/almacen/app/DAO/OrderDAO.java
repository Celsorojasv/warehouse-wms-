package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.almacen.app.models.Order;

@Repository
public class OrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
}

