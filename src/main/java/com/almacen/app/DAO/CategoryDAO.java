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
import com.almacen.interfaces.ICategoryService;

@Service
public class CategoryDAO implements ICategoryService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall call;
	
	public CategoryDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional(readOnly = true)
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
	

	@Transactional
	@Override
	public void createCategory(Category category) {
		// TODO Auto-generated method stub
		
		//pname,pdescription
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_category");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pname", category.getNameCategory());
		map.put("pdescription", category.getDescriptionCategory());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
	}
	
	@Transactional
	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		//pname,pdescription
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_category");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pid_category", category.getIdCategory());
		map.put("pname", category.getNameCategory());
		map.put("pdescription", category.getDescriptionCategory());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
		
	}
	
	@Transactional
	@Override
	public void deleteCategory(Integer idCategory) {
		// TODO Auto-generated method stub
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_category");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_category", idCategory);
		call.execute(src);
		
	}
	

}
