package com.ez.admin.dao;

import java.util.List;

import com.ez.model.entity.BankEntity;
import com.ez.model.entity.DepartmentEntity;

public interface DepartmentDAO {
	
	public List<DepartmentEntity> departmentList();
	public String addBank(DepartmentEntity deptEntity);
	public String deleteDept(int[] deptId);
	public String updateDepartment(DepartmentEntity departmentEntity);
	public DepartmentEntity departmentById(int departmentId);

}
