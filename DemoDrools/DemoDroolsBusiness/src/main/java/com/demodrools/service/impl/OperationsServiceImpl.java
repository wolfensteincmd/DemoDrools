/**
 * 
 */
package com.demodrools.service.impl;

import org.kie.api.runtime.rule.FactHandle;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demodrools.dao.OperationsDao;
import com.demodrools.pojo.Operations;
import com.demodrools.service.OperationsService;

/**
 * @author erick
 *
 */
@Service
public class OperationsServiceImpl implements OperationsService {
	
	@Autowired
	OperationsDao operationsDao;
	
	public Operations executeOperation(String origin, String destination, double amount){
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("operationsSession");
    	
    	Operations operations = new Operations();
    	operations.setOrigin(origin);
    	operations.setDestination(destination);
    	operations.setAmount(amount);
    	operations.setBalance(operationsDao.getBalance(origin));
    	operations.setBalance2(operationsDao.getBalance(destination));
    	
    	FactHandle operationsHandle = kSession.insert(operations);
    	kSession.fireAllRules();
    	Operations opReturn = (Operations) kSession.getObject(operationsHandle);
    	
    	if(opReturn.getMessage() == null){
    		opReturn.setMessage("Operation not allowed");
    	} else if(opReturn.getMessage().equals("Operation complete")){
    		operationsDao.executeOperation(opReturn);
    	}
    	
		return opReturn;
	}
	
	public List<List<String>> getAccounts(){
		return operationsDao.getAccounts();
	}

}
