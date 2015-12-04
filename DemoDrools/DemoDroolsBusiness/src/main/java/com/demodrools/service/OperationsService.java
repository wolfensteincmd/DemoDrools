/**
 * 
 */
package com.demodrools.service;

import java.util.List;

import com.demodrools.pojo.Operations;

/**
 * @author erick
 *
 */
public interface OperationsService {
	
	public Operations executeOperation(String origin, String destination, double amount);

	public List<List<String>> getAccounts();
}
