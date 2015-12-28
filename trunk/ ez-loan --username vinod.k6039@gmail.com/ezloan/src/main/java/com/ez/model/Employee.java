package com.ez.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 ****************************
 ***@author nagendra.yadav***
 ****************************
 * 
 */
@XmlRootElement
public class Employee implements Serializable {
	
	/**
	 * The serialVersionUID
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private int empId;
	private String empName;
	private String designation;
	private String email;
	private String contact;
	private String department;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
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
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", designation=" + designation + ", email=" + email
				+ ", contact=" + contact + ", department=" + department + "]";
	}
	
	public Employee(int empId, String empName, String designation,
			String email, String contact, String department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.email = email;
		this.contact = contact;
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
