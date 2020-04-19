package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.almacen.app.models.Product;
import com.almacen.app.models.Provider;
import com.almacen.app.models.ProviderByProduct;
import com.almacen.app.models.WarehouseUser;

@Service
public class ProviderByProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
				py.setIdProvider(provider);
				
				product.setIdProduct(rs.getLong("id_product"));
				py.setIdProduct(product);

				warehouse.setIdUser(rs.getLong("id_user"));
				py.setIdUser(warehouse);
				
				py.setQuantity(rs.getInt("quantity"));
				py.setPriceProduct(rs.getDouble("price_product"));
				
				return py;
			}
		});
		
		
		return listProByPro;
	}

	
}
