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

import com.almacen.app.models.Category;
import com.almacen.app.models.Product;
import com.almacen.interfaces.IProductService;

@Service
public class ProductDAO implements IProductService{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall call;


	public List<Product> list(){
		String sql = "SELECT * FROM PRODUCT";
		
				List<Product> listProduct = jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Product p = new Product();
				Category c = new Category();
				
				p.setIdProduct(rs.getLong("id_product"));
				p.setNameProduct(rs.getNString("name_product"));
				p.setCreatedProduct(rs.getDate("created_product"));
				c.setIdCategory(rs.getLong("id_category"));
				p.setCategory(c);
				
				return p;
			}
		});
	
		return listProduct;
	}

	@Transactional
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		//pname_product,created_product,pid_category
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_product");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pname_product", product.getNameProduct());
		map.put("pcreated_product", product.getCreatedProduct());
		map.put("pid_category", product.getCategory().getIdCategory());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
	
		call.execute(src);
	}


	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		//pid_product,pname_product,created_product,pid_category
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_product");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_product", product.getIdProduct());
		map.put("pname_product", product.getNameProduct());
		map.put("pcreated_product", product.getCreatedProduct());
		map.put("pid_category", product.getCategory().getIdCategory());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
	
		call.execute(src);
	}


	@Override
	public void deleteProduct(Integer idProduct) {
		// TODO Auto-generated method stub
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_product"); 
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_product", idProduct);
		call.execute(src);
	}

}
