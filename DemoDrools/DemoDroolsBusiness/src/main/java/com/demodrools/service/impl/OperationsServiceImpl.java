/**
 * 
 */
package com.demodrools.service.impl;

import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import java.io.File;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
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
		
		String fileName = "/Users/erick/OperationsTables.xls";
		
		KieServices ks = KieServices.Factory.get();
		
		File file = new File(fileName);
	    Resource resource = ks.getResources().newFileSystemResource(file).setResourceType(ResourceType.DTABLE);
	    KieFileSystem kFileSystem = ks.newKieFileSystem();
	    kFileSystem.write( resource );
	    KieBuilder kbuilder = ks.newKieBuilder( kFileSystem );
        // kieModule is automatically deployed to KieRepository if successfully built.
        kbuilder.buildAll();

        if (kbuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            throw new RuntimeException("Build time Errors: " + kbuilder.getResults().toString());
        }
        
        KieContainer kContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
		
	    //KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession();
    	
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
