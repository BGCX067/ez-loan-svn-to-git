package com.ez.admin.dao;

import java.util.List;

import com.ez.model.entity.EmployeeEntity;

public interface EmployeeDAO {
	
	public String addEmployee(EmployeeEntity empEntity, String department);
	public List<EmployeeEntity> employeeList(String department);

}
