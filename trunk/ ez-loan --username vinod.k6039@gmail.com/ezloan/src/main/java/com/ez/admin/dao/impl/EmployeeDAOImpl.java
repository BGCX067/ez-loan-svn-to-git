package com.ez.admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ez.admin.dao.EmployeeDAO;
import com.ez.model.entity.DepartmentEntity;
import com.ez.model.entity.EmployeeEntity;

@Repository("EmployeeDAOImpl")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext(unitName="JPAezLoan")
	private EntityManager entityManager;
	
	
	
	public Query empListQuery;

	@Override
	public String addEmployee(EmployeeEntity empEntity, String department) {

		Query query = entityManager
				.createQuery("select d from DepartmentEntity d where d.name=:deptname");
		query.setParameter("deptname", department);
		DepartmentEntity departmentEntity = (DepartmentEntity) query
				.getSingleResult();

		empEntity.setDepartment(departmentEntity);
		List<EmployeeEntity> empList = new ArrayList<EmployeeEntity>();
		empList.add(empEntity);
		departmentEntity.setEmpList(empList);
		entityManager.persist(departmentEntity);
		return "Employee-Added";
	}

	@Override
	public List<EmployeeEntity> employeeList(String department) {
		if (department.equals("ALL")) {
			empListQuery = entityManager.createQuery("from EmployeeEntity");
		} else {
	/*		empListQuery = entityManager.createNativeQuery(
					"select * from emp_tbl where department = :department",
					EmployeeEntity.class);
	*/		empListQuery = entityManager.createQuery("from EmployeeEntity as ee where ee.department.name='"+department+"'");
		}
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) empListQuery
				.getResultList();
		return employeeList;
	}

}
