package com.almacen.app.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.almacen.app.models.Category;

@Service
public class CategoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public CategoryDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Category> list(){
		String sql = "SELECT * FROM CATEGORY";
		
		List<Category> listCategory = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Category c = new Category();
				
				c.setIdCategory(rs.getLong("id_category"));
				c.setNameCategory(rs.getString("name"));
				c.setDescriptionCategory(rs.getString("description"));

				return c;
			}
		});
		
		return listCategory;
		
				
	}

}
