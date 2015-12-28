package com.ez.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ez.admin.dao.CustomerDAO;
import com.ez.admin.service.CustomerService;
import com.ez.model.Customer;
import com.ez.model.entity.CustomerEntity;


@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("CustomerDAOImpl")
	private CustomerDAO customerDAO;

	@Override
	public String addCustomer(Customer customer) {
		//This is a Spring Utility Code where we are 
		//copying data from VO to Entity Object
		CustomerEntity customerEntity = BeanUtils
				.instantiate(CustomerEntity.class);
		BeanUtils.copyProperties(customer, customerEntity);
		String success = customerDAO.addCustomer(customerEntity);
		return success;
	}

	@Override
	public String validateCustomer(String username, String password) {
		return customerDAO.validateCustomer(username, password);
	}

	@Override
	public ArrayList<Customer> customerList(String applicationStatus) {
		List<CustomerEntity> customerEntityList = customerDAO.customerList(applicationStatus);
		List<Customer> customerList = new ArrayList<Customer>();
		for(CustomerEntity entity : customerEntityList){
			Customer customer = BeanUtils.instantiate(Customer.class);
			BeanUtils.copyProperties(entity, customer);
			customerList.add(customer);
		}
		return (ArrayList<Customer>)customerList;
	}

	
	/**
	 * @param username
	 * @return Customer 
	 */
	@Override
	public Customer findCustomerByUserName(String username) {
	     CustomerEntity customerEntity = customerDAO.findCustomerByUserName(username);
	     Customer customer = BeanUtils.instantiate(Customer.class);
		 if(customerEntity!=null){ 
	      BeanUtils.copyProperties(customerEntity, customer);
		 }
		return customer;
	}



	@Override
	public String decideCustomer(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customer.getId());
		customerEntity.setApplicationStatus(customer.getApplicationStatus());
		return customerDAO.decideCustomer(customerEntity);
	}

}
