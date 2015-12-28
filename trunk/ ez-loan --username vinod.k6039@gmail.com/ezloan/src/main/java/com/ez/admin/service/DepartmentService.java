package com.ez.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.ez.model.Bank;
import com.ez.model.Department;


public interface DepartmentService {
	
	public ArrayList<Department> departmentList();
	public String addBank(Department department);
	public String deleteDept(int[] deptId);
	public String updateDepartment(Department department);
	public Department departmentById(int departmentId);

}
