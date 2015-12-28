package com.ez.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ez.admin.dao.EmployeeDAO;
import com.ez.admin.service.EmployeeService;
import com.ez.model.Employee;
import com.ez.model.entity.EmployeeEntity;

/**
 * 
 * @author nagendra.yadav
 *  caching Implementation
 *
 */
@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	@Qualifier("EmployeeDAOImpl")
	private EmployeeDAO employeeDAO;
	
	@CacheEvict(value="ezloanCache",allEntries=true)
	@Override
	public String addEmployee(Employee employee, String department) {
		//EmployeeEntity entity = BeanUtils.instantiate(EmployeeEntity.class);
		//BeanUtils.copyProperties(employee, entity,new String[]{"empId"});
		EmployeeEntity entity = new EmployeeEntity();
		entity.setContact(employee.getContact());
		entity.setDesignation(employee.getDesignation());
		entity.setEmail(employee.getEmail());
		entity.setEmpName(employee.getEmpName());
		return employeeDAO.addEmployee(entity, department);
	}

	@Cacheable(value="ezloanCache",key="#department")
	@Override
	public ArrayList<Employee> employeeList(final String department) {
		List<EmployeeEntity> empEntityList = employeeDAO.employeeList(department);
		ArrayList<Employee> empList = new ArrayList<Employee>();
		for(EmployeeEntity entity:empEntityList){
			Employee employee = new Employee(entity.getEmpId(),entity.getEmpName(),entity.getDesignation(),
								entity.getEmail(),entity.getContact(),entity.getDepartment().getName());
			empList.add(employee);
		}
		return empList;
	}

}
