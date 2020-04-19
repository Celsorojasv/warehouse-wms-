package com.almacen.app.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.almacen.app.models.Provider;

@Service
public class ProviderDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Provider> list(){
		
		String sql = "SELECT * FROM PROVIDER";
		
		List<Provider> listProvider = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Provider.class));
		
		return listProvider;
	}

}
