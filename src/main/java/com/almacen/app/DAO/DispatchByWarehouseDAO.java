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

import com.almacen.app.models.Branch;
import com.almacen.app.models.DispatchByWarehouse;
import com.almacen.app.models.WarehouseUser;
import com.almacen.interfaces.IDispatchByWarehouseService;

@Service
public class DispatchByWarehouseDAO implements IDispatchByWarehouseService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;
	
	public List<DispatchByWarehouse> list(){
		String sql = "SELECT * FROM DISPATCH_BY_WAREHOUSE";
		
		List<DispatchByWarehouse> listDisByWare = jdbcTemplate.query(sql, new RowMapper<DispatchByWarehouse>() {

			@Override
			public DispatchByWarehouse mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				DispatchByWarehouse d = new DispatchByWarehouse();
				Branch b = new Branch();
				WarehouseUser w = new WarehouseUser();
				
				d.setIdDispatchWarehouse(rs.getLong("id_dispatch_by_warehouse"));
				b.setIdBranch(rs.getLong("id_branch"));
				d.setBranch(b);
				w.setIdUser(rs.getLong("id_user"));
				d.setWarehouseUser(w);
				d.setLastSend(rs.getDate("last_sent"));
				
				return d;
			}
		});
		return listDisByWare;
	}

	
	@Override
	public void createDetail(DispatchByWarehouse disWare) {
		// TODO Auto-generated method stub
		//pid_branch,pid_user,plast_sent
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_dispatch_by_warehouse");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_branch", disWare.getBranch().getIdBranch());
		map.put("pid_user", disWare.getWarehouseUser().getIdUser());
		map.put("plast_sent", disWare.getLastSend());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}

	@Override
	public void updateDetail(DispatchByWarehouse disWare) {
		// TODO Auto-generated method stub
		//pid_dispatch_by_warehouse,pid_branch,pid_user,plast_sent
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_dispatch_by_warehouse");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_dispatch_by_warehouse", disWare.getIdDispatchWarehouse());
		map.put("pid_branch", disWare.getBranch().getIdBranch());
		map.put("pid_user", disWare.getWarehouseUser().getIdUser());
		map.put("plast_sent", disWare.getLastSend());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
		
		
	}

	@Override
	public void deleteDetail(Integer idDisWare) {
		// TODO Auto-generated method stub
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_dispatch_by_warehouse");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_dispatch_by_warehouse", idDisWare);
		
		call.execute(src);
		
	}

	
}



