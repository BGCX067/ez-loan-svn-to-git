package com.ez.admin.service;

import java.util.ArrayList;

import com.ez.model.Customer;

public interface CustomerService {
	
	public String addCustomer(Customer customer);

	public String validateCustomer(String username, String password);
	
	public ArrayList<Customer> customerList(String applicationStatus);
	
	public String decideCustomer(Customer customer);

	Customer findCustomerByUserName(String username);
	

}
