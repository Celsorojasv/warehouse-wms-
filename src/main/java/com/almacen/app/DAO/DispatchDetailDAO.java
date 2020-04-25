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

import com.almacen.app.models.DispatchByWarehouse;
import com.almacen.app.models.DispatchDetail;
import com.almacen.app.models.ProviderByProduct;
import com.almacen.interfaces.IDispatchDetailsService;

@Service
public class DispatchDetailDAO implements IDispatchDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;

	String sql = "SELECT * FROM DISPATCH_DETAILS";

	public List<DispatchDetail> list(){
		
		List<DispatchDetail> listDispDetail = jdbcTemplate.query(sql, new RowMapper<DispatchDetail>() {

			@Override
			public DispatchDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				DispatchDetail d = new DispatchDetail();
				DispatchByWarehouse dw = new DispatchByWarehouse();
				ProviderByProduct	py = new ProviderByProduct();
				
				d.setIdDispatch(rs.getLong("id_dispatch"));
				dw.setIdDispatchWarehouse(rs.getLong("id_dispatch_by_warehouse"));
				d.setDispatchWarehouse(dw);
				d.setQuantityOut(rs.getInt("quantity_out"));
				py.setIdProviderProduct(rs.getLong("id_provider_by_product"));
				d.setProviderProduct(py);
				
				return d;
			}
		});
		
	return listDispDetail;
	}

	@Transactional
	@Override
	public void createDetail(DispatchDetail detail) {
		// TODO Auto-generated method stub
		//pid_dispatch_by_warehouse,pquantity_out,pid_provider_by_product
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_dispatch_details");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_dispatch_by_warehouse", detail.getDispatchWarehouse().getIdDispatchWarehouse());
		map.put("pquantity_out", detail.getQuantityOut());
		map.put("pid_provider_by_product", detail.getProviderProduct().getIdProviderProduct());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
		
	}

	@Transactional
	@Override
	public void updateDetail(DispatchDetail detail) {
		// TODO Auto-generated method stub
		//pid_dispatch,pid_dispatch_by_warehouse,pquantity_out,pid_provider_by_product
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_dispatch_details");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_dispatch", detail.getIdDispatch());
		map.put("pid_dispatch_by_warehouse", detail.getDispatchWarehouse().getIdDispatchWarehouse());
		map.put("pquantity_out", detail.getQuantityOut());
		map.put("pid_provider_by_product", detail.getProviderProduct().getIdProviderProduct());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}

	@Transactional
	@Override
	public void deleteDetail(Integer idDetail) {
		// TODO Auto-generated method stub
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_dispatch_details");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_dispatch", idDetail);
		
		call.execute(src);
	}
		
}
