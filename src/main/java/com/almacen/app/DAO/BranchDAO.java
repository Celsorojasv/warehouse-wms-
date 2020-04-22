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

import com.almacen.app.models.Branch;
import com.almacen.interfaces.IBranchService;

@Service
public class BranchDAO  implements IBranchService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall call;
	
	
	public BranchDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional(readOnly = true)
	public List<Branch> list(){
	
		String sql = "SELECT * FROM BRANCH";
		
		List<Branch> listBranch = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Branch.class));
		
		return listBranch;
		
	}


	@Transactional
	@Override
	public void createBranch(Branch branch) {
		// TODO Auto-generated method stub
		
		//Pname_branch,Paddress_branch,Pphone_branch
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_branch");
		Map<String, Object> culoMap = new HashMap<String, Object>();
		culoMap.put("Pname_branch", branch.getNameBranch());
		culoMap.put("Paddress_branch", branch.getAddressBranch());
		culoMap.put("Pphone_branch", branch.getPhoneBranch());
		
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(culoMap);
		call.execute(src);
	}
	
	@Transactional
	@Override
	public void updateBranch(Branch branch) {
		// TODO Auto-generated method stub
		
		//Pid_branch,Pname_branch,Paddress_branch,Pphone_branch
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("update_branch");
		Map<String, Object> culoMap = new HashMap<String, Object>();
		
		culoMap.put("Pid_branch", branch.getIdBranch());
		culoMap.put("Pname_branch", branch.getNameBranch());
		culoMap.put("Paddress_branch", branch.getAddressBranch());
		culoMap.put("Pphone_branch", branch.getPhoneBranch());
		
		SqlParameterSource src = new MapSqlParameterSource()
				.addValues(culoMap);
		call.execute(src);
		
	}
	
	@Transactional
	@Override
	public void deleteBranch(Integer idBranch) {
		// TODO Auto-generated method stub
		call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_branch");
		SqlParameterSource src = new MapSqlParameterSource()
				.addValue("Pid_branch", idBranch);
		
		call.execute(src);
		
	}



}