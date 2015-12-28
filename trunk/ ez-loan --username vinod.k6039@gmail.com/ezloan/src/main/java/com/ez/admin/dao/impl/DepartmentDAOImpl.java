package com.ez.admin.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ez.admin.dao.DepartmentDAO;
import com.ez.model.entity.DepartmentEntity;

@Repository("DepartmentDAOImpl")
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

	@PersistenceContext(unitName="JPAezLoan")
	private EntityManager entityManager;

	@Override
	public List<DepartmentEntity> departmentList() {
		Query query = entityManager.createQuery("from DepartmentEntity");
		List<DepartmentEntity> departmentList = (List<DepartmentEntity>) query
				.getResultList();
		return departmentList;
	}

	@Override
	public String addBank(DepartmentEntity deptEntity) {
		entityManager.persist(deptEntity);
		return "Department-Added";
	}

	@Override
	public String deleteDept(int[] deptId) {

		for (int i : deptId) {
			Query query = entityManager
					.createQuery("delete from DepartmentEntity de where de.deptId = :id");
			query.setParameter("id", i);
			int deleteRecord = query.executeUpdate();
		}
		return "Departments-Deleted";
	}

	@Override
	public String updateDepartment(DepartmentEntity departmentEntity) {

	/*	DepartmentEntity departmentEntity2 = entityManager.find(
				DepartmentEntity.class, departmentEntity.getDeptId());
		
		Query empListQuery = entityManager.createNativeQuery("select * from emp_tbl where department = :department", EmployeeEntity.class);
		empListQuery.setParameter("department", departmentEntity2.getName());
		
		List<EmployeeEntity> empList = (List<EmployeeEntity>)empListQuery.getResultList();
		
		for (EmployeeEntity employeeEntity : empList) {
			
		}*/
		
		//departmentEntity2.setName(departmentEntity.getName());
		//departmentEntity2.setContact(departmentEntity.getContact());
		//departmentEntity2.setCode(departmentEntity.getCode());
		entityManager.merge(departmentEntity);
		return "departmentUpdated";
	}

	@Override
	public DepartmentEntity departmentById(int departmentId) {
		DepartmentEntity departmentEntity = entityManager.find(
				DepartmentEntity.class, departmentId);
		return departmentEntity;
	}
}
