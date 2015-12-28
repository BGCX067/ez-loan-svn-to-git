package com.ez.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.admin.service.CustomerService;
import com.ez.common.constant.ApplicationConstant;
import com.ez.model.Customer;

@Controller
@RequestMapping("/admin")
public class CustomerController implements ApplicationConstant {

	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	private String applicationStatus = "ALL";
	
	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	@RequestMapping(value="customers.htm", method=RequestMethod.GET)
	public String showCustomers(Model model){
		
		String[] applicationTypes = this.applicationTypes;
		
		List<Customer> customerList = customerService.customerList(this.getApplicationStatus());
		model.addAttribute("customerList",customerList);
		model.addAttribute("applicationTypes", applicationTypes);
		
		return "customers";
	}
	
	@RequestMapping(value="customerByDept.htm", method=RequestMethod.GET)
	public String getEmpList(@RequestParam(value="applicationStatus") String applicationStatus, Model model){
		this.setApplicationStatus(applicationStatus);
		return "redirect:customers.htm";
	}
	
	@RequestMapping(value = "customerDecision.htm", method = RequestMethod.GET)
	public String customerDecision(@RequestParam("id") String Id,
			@RequestParam("decision") String decision) {
		int selectedId = Integer.parseInt(Id);
		Customer customer = new Customer();
		customer.setId(selectedId);
		customer.setApplicationStatus(decision);
		customerService.decideCustomer(customer);
		return "redirect: goHome.htm";
	}
	
	
}
