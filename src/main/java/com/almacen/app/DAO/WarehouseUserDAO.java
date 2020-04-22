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
import org.springframework.transaction.annotation.Transactional;

import com.almacen.app.models.WarehouseUser;
import com.almacen.interfaces.IWarehouseUserService;

@Service
public class WarehouseUserDAO implements IWarehouseUserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;


	@Transactional(readOnly = true)
	public List<WarehouseUser> list(){
	
	String sql = "SELECT * FROM WAREHOUSE_USER";

	List<WarehouseUser> listUser = jdbcTemplate.query(sql, new RowMapper<WarehouseUser>() {


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


	@Override
	public void createWareUser(WarehouseUser ware) {
		// TODO Auto-generated method stub
		
		//pname_user,pphone_user,pjob_title
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_warehouse_user");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pname_user", ware.getNameUser());
		map.put("pphone_user", ware.getPhoneUser());
		map.put("pjob_title", ware.getJobTitle());
		
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
	}
	
		


	@Override
	public void updateWareUser(WarehouseUser ware) {
		// TODO Auto-generated method stub
		//pid_user,pname_user,pphone_user,pjob_title
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_warehouse_user");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_user", ware.getIdUser());
		map.put("pname_user", ware.getNameUser());
		map.put("pphone_user", ware.getPhoneUser());
		map.put("pjob_title", ware.getJobTitle());
		
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
	}


	@Override
	public void deleteWareUser(Integer idWarehouseUser) {
		// TODO Auto-generated method stub
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_warehouse_user");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_user", idWarehouseUser);
		
		call.execute(src);
	}
	
}
