package com.ez.model;

public class Department {
	
	private int deptId;
	private String name;
	private String code;
	private String contact;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Department(int deptId, String name, String code, String contact) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.code = code;
		this.contact = contact;
	}
	
	public Department() {
		super();
	}
	
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", code="
				+ code + ", contact=" + contact + "]";
	}
	
}
