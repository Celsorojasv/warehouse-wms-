package com.almacen.app.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.app.models.Provider;
import com.almacen.interfaces.IProviderService;

@Service
public class ProviderDAO implements IProviderService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;
	
	
	@Transactional(readOnly = true)
	public List<Provider> list(){
		
		String sql = "SELECT * FROM PROVIDER";
		
		List<Provider> listProvider = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Provider.class));
		
		return listProvider;
	}

	@Transactional
	@Override
	public void createProvider(Provider provider) {
		// TODO Auto-generated method stub
		//pname_provider,pnit_provider,pphone_provider,paddress_provider
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_provider");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pname_provider", provider.getNameProvider());
		map.put("pnit_provider", provider.getNitProvider());
		map.put("pphone_provider", provider.getPhoneProvider());
		map.put("paddress_provider", provider.getAddressProvider());
		
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		//pid_provider,pname_provider,pnit_provider,pphone_provider,paddress_provider
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_provider");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("pid_provider", provider.getIdProvider());
		map.put("pname_provider", provider.getNameProvider());
		map.put("pnit_provider", provider.getNitProvider());
		map.put("pphone_provider", provider.getPhoneProvider());
		map.put("paddress_provider", provider.getAddressProvider());
		
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(map);
		call.execute(src);
	}

	@Override
	public void deleteProvider(Integer idProvider) {
		// TODO Auto-generated method stub
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_provider");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("pid_provider", idProvider);
		
		call.execute(src);
		
	}

}
