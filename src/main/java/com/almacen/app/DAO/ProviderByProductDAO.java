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

import com.almacen.app.models.Product;
import com.almacen.app.models.Provider;
import com.almacen.app.models.ProviderByProduct;
import com.almacen.app.models.WarehouseUser;
import com.almacen.interfaces.IProviderByProductService;

@Service
public class ProviderByProductDAO implements IProviderByProductService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;
	
	public List<ProviderByProduct> list(){
		
		String sql = "SELECT * FROM PROVIDER_BY_PRODUCT";
		//Crear Vista para evitar los Nulls en el postman
		
		List<ProviderByProduct> listProByPro = jdbcTemplate.query(sql, new RowMapper<ProviderByProduct>(){

			@Override
			public ProviderByProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				ProviderByProduct py = new ProviderByProduct();
				
				Product product = new Product();
				
				Provider provider = new Provider();
				
				WarehouseUser warehouse = new WarehouseUser();
				
				
				py.setIdProviderProduct(rs.getLong("id_provider_by_product"));
				py.setLastAdded(rs.getDate("last_added"));
				
				provider.setIdProvider(rs.getLong("id_provider"));				
				py.setProvider(provider);
				
				product.setIdProduct(rs.getLong("id_product"));
				py.setProduct(product);

				warehouse.setIdUser(rs.getLong("id_user"));
				py.setwUser(warehouse);
				
				py.setQuantity(rs.getInt("quantity"));
				py.setPriceProduct(rs.getDouble("price_product"));
				
				return py;
			}
		});
		
		
		return listProByPro;
	}

	@Override
	public void createProByProd(ProviderByProduct ProByP) {
		// TODO Auto-generated method stub create_provider_by_product
		//plast_added,pid_provider,pid_product,pid_user,pquantity,pprice_product
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_provider_by_product");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("plast_added", ProByP.getLastAdded());
		map.put("pid_provider", ProByP.getProvider().getIdProvider());
		map.put("pid_product", ProByP.getProduct().getIdProduct());
		map.put("pid_user", ProByP.getwUser().getIdUser());
		map.put("pquantity", ProByP.getQuantity());
		map.put("pprice_product", ProByP.getPriceProduct());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}

	@Override
	public void updateProByProd(ProviderByProduct ProByP) {
		// TODO Auto-generated method stub delete_provider_by_product
		//pid_provider_by_product,plast_added,pid_provider,pid_product,pid_user,pquantity,pprice_product

		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_provider_by_product");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_provider_by_product", ProByP.getIdProviderProduct());
		map.put("plast_added", ProByP.getLastAdded());
		map.put("pid_provider", ProByP.getProvider().getIdProvider());
		map.put("pid_product", ProByP.getProduct().getIdProduct());
		map.put("pid_user", ProByP.getwUser().getIdUser());
		map.put("pquantity", ProByP.getQuantity());
		map.put("pprice_product", ProByP.getPriceProduct());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
		
		
	}

	@Override
	public void deleteProByProd(Integer idProByP) {
		// TODO Auto-generated method stub delete_provider_by_product
		
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_provider_by_product");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_provider_by_product", idProByP);
		
		call.execute(src);
	}

}
