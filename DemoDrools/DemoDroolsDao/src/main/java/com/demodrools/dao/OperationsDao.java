package com.demodrools.dao;

import java.util.List;

import com.demodrools.pojo.Operations;

public interface OperationsDao {

	public void executeOperation(Operations op);
	
	public double getBalance(String id);
	
	public List<List<String>> getAccounts();
}
