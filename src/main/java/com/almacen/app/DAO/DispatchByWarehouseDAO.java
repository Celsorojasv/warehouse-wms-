package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.almacen.app.models.Branch;
import com.almacen.app.models.DispatchByWarehouse;
import com.almacen.app.models.WarehouseUser;

@Service
public class DispatchByWarehouseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
				d.setIdBranch(b);
				w.setIdUser(rs.getLong("id_user"));
				d.setIdUser(w);
				d.setLastSend(rs.getDate("last_sent"));
				
				return d;
			}
		});
		
		return listDisByWare;
	}	
}

