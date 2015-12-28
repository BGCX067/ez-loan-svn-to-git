package com.ez.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ez.admin.dao.DepartmentDAO;
import com.ez.admin.service.DepartmentService;
import com.ez.model.Department;
import com.ez.model.entity.DepartmentEntity;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	@Qualifier("DepartmentDAOImpl")
	private DepartmentDAO departmentDAO;

	@Override
	public ArrayList<Department> departmentList() {

		List<DepartmentEntity> entityList = departmentDAO.departmentList();
		ArrayList<Department> deptList = new ArrayList<Department>();

		for (DepartmentEntity entity : entityList) {
			Department dept = new Department(entity.getDeptId(),
					entity.getName(), entity.getCode(), entity.getContact());
			deptList.add(dept);
		}

		return deptList;
	}

	@Override
	public String addBank(Department department) {
		DepartmentEntity entity = BeanUtils.instantiate(DepartmentEntity.class);
		BeanUtils.copyProperties(department, entity, new String[] { "deptId" });
		return departmentDAO.addBank(entity);
	}

	@Override
	public String deleteDept(int[] deptId) {
		return departmentDAO.deleteDept(deptId);
	}

	@Override
	public String updateDepartment(Department department) {

		DepartmentEntity departmentEntity = BeanUtils
				.instantiate(DepartmentEntity.class);
		BeanUtils.copyProperties(department, departmentEntity);
		return departmentDAO.updateDepartment(departmentEntity);

	}

	@Override
	public Department departmentById(int departmentId) {

		Department department = BeanUtils.instantiate(Department.class);
		DepartmentEntity departmentEntity = departmentDAO.departmentById(departmentId);
		BeanUtils.copyProperties(departmentEntity, department);
		return department;
		
		

	}

}
