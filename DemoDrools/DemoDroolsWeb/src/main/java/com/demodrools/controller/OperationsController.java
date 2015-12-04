/**
 * 
 */
package com.demodrools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demodrools.pojo.Operations;
import com.demodrools.service.OperationsService;

/**
 * @author erick
 *
 */
@Controller
public class OperationsController {
	
	@Autowired
	private OperationsService operationsService;

	@RequestMapping(value = "/operation", method = RequestMethod.GET)
	public ModelAndView makeOperation(@RequestParam String origin, @RequestParam String destination,
			@RequestParam double amount, ModelMap model) {
		Operations result = operationsService.executeOperation(origin, destination, amount);
		model.addAttribute("origin", result.getOrigin());
		model.addAttribute("destination", result.getDestination());
		model.addAttribute("amount", result.getAmount());
		model.addAttribute("message", result.getMessage());
		ModelAndView mav =new ModelAndView();
		mav.setViewName("result");
		mav.addAllObjects(model);
		return mav;
	}
	
	@RequestMapping(value = "/StartOperation", method = RequestMethod.GET)
	public ModelAndView startOperation(ModelMap model){
		ModelAndView mav =new ModelAndView();
		model.addAttribute("accounts", operationsService.getAccounts());
		mav.setViewName("Start");
		mav.addAllObjects(model);
		return mav;
	}

}
