package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.almacen.app.models.WarehouseUser;

@Service
public class WarehouseUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<WarehouseUser> list(){
	
	String sql = "SELECT * FROM WAREHOUSE_USER";

	List<WarehouseUser> listUser = jdbcTemplate.query(sql, new RowMapper<WarehouseUser>() {

		@Override
		public WarehouseUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			WarehouseUser w = new WarehouseUser();
			
			w.setIdUser(rs.getLong("id_user"));
			w.setNameUser(rs.getNString("name_user"));
			w.setPhoneUser(rs.getString("phone_user"));
			w.setJobTitle(rs.getString("job_title"));
			
			return w;
			}
		});
	
	return listUser;
	
	}
}
