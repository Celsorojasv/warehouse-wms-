package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.almacen.app.models.Category;
import com.almacen.app.models.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

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
				p.setIdCategory(c);
				
				return p;
			}
		});
	
		return listProduct;
	}

}
