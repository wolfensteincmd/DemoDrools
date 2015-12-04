package com.demodrools.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demodrools.dao.OperationsDao;
import com.demodrools.pojo.Operations;

@Repository
public class OperationsDaoImpl implements OperationsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void executeOperation(Operations op){
		StringBuilder sb = new StringBuilder("UPDATE accounts SET balance = balance + (");
		sb.append(op.getAmount());
		sb.append(") WHERE ID = '").append(op.getOrigin()).append("'");
		jdbcTemplate.execute(sb.toString());
		sb = new StringBuilder("UPDATE accounts SET balance = balance - (");
		sb.append(op.getAmount());
		sb.append(") WHERE ID = '").append(op.getDestination()).append("'");
		jdbcTemplate.execute(sb.toString());
	}
	
	public double getBalance(String id){
		StringBuilder sb = new StringBuilder("SELECT balance FROM accounts where id = '").append(id).append("'");
		Double balance = jdbcTemplate.queryForObject(sb.toString(), Double.class);
		return balance.doubleValue();
	}
	
	public List<List<String>> getAccounts(){
		StringBuilder sb  = new StringBuilder("Select * from accounts");
		List results = jdbcTemplate.queryForList(sb.toString());
		List<List<String>> ret = new ArrayList<List<String>>();
		List<String> aux;
		for (Object o : results){
			Map m = (Map) o;
			aux = new ArrayList<String>();
			aux.add(m.get("id").toString());
			aux.add(m.get("balance").toString());
			ret.add(aux);
		}
		return ret;
	}
	
}
