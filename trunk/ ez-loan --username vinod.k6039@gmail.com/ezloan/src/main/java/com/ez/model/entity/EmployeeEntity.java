package com.ez.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="emp_tbl")
public class EmployeeEntity {
	
	private int empId;
	private String empName;
	private String designation;
	private String email;
	private String contact;
	private DepartmentEntity department;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="department",referencedColumnName="deptId")
	public DepartmentEntity getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", empName=" + empName
				+ ", designation=" + designation + ", email=" + email
				+ ", contact=" + contact + "]";
	}
	
	
	
	public EmployeeEntity(String empName, String designation,
			String email, String contact, DepartmentEntity department) {
		super();
		this.empName = empName;
		this.designation = designation;
		this.email = email;
		this.contact = contact;
		this.department = department;
	}
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
