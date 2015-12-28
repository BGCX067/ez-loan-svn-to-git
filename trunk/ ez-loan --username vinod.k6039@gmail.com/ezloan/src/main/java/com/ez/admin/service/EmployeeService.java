package com.ez.admin.service;

import java.util.ArrayList;

import com.ez.model.Employee;

public interface EmployeeService {
	
	public String addEmployee(Employee employee, String department);
	public ArrayList<Employee> employeeList(String department);

}
