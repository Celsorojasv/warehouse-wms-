package com.almacen.app.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.almacen.app.models.Branch;

@Repository
public class BranchDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public BranchDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Branch> list(){
	
		String sql = "SELECT * FROM BRANCH";
		
		List<Branch> listBranch = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Branch.class));
		
		return listBranch;
		
	}
	
}