package com.ez.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.admin.service.CustomerService;
import com.ez.model.Customer;
import com.ez.model.CustomerList;

/**
 * 
 * @author ADMIN-2
 *   This controller expose functionality as a restful web service.
 *   
 */
@Controller
public class EZLoanRestController {
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	@RequestMapping(value = "customersByStatus", method = RequestMethod.GET, headers = "Accept=application/xml")
	public  @ResponseBody CustomerList findCustomerByStatus(@RequestParam(value = "applicationStatus", required = false)
	String applicationStatus){
		List<Customer> customers=customerService.customerList(applicationStatus);
		CustomerList customerList=new CustomerList();
		customerList.setCustomers(customers);
		return customerList;
	}

}
