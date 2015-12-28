package com.ez.admin.dao;

import java.util.List;

import com.ez.model.entity.CustomerEntity;


/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CustomerDAO {
	
	public String addCustomer(CustomerEntity customerEntity);
	public String validateCustomer(String username, String password);
	public List<CustomerEntity> customerList(String applicationStatus); 
	public String decideCustomer(CustomerEntity customerEntity);
	public CustomerEntity findCustomerByUserName(String username);

}
