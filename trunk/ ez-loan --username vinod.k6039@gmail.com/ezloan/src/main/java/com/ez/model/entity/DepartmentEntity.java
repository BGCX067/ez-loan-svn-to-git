package com.ez.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="departments",uniqueConstraints={@UniqueConstraint(columnNames="name"),
		@UniqueConstraint(columnNames="code")})
public class DepartmentEntity implements Serializable{
	
	private int deptId;
	private String name;
	private String code;
	private String contact;
	
	private List<EmployeeEntity> empList;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="deptId")
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="contact")
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL, mappedBy="department")
	public List<EmployeeEntity> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmployeeEntity> empList) {
		this.empList = empList;
	}
	
	public DepartmentEntity(int deptId, String name, String code,
			String contact, List<EmployeeEntity> empList) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.code = code;
		this.contact = contact;
		this.empList = empList;
	}
	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", name=" + name
				+ ", code=" + code + ", contact=" + contact + ", empList="
				+ empList + "]";
	}
	
		
	
}
