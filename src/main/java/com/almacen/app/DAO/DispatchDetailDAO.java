package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.almacen.app.models.DispatchByWarehouse;
import com.almacen.app.models.DispatchDetail;
import com.almacen.app.models.ProviderByProduct;

@Service
public class DispatchDetailDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
				dw.setDispatchWarehouse(rs.getLong("id_dispatch_by_warehouse"));
				d.setIdDispatchWarehouse(dw);
				d.setQuantityOut(rs.getInt("quantity_out"));
				py.setIdProviderProduct(rs.getLong("id_provider_by_product"));
				d.setIdProviderProduct(py);
				
				return d;
			}
		});
		
	return listDispDetail;
	}
}
