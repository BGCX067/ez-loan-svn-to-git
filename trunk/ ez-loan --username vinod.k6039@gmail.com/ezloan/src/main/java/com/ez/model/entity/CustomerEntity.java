package com.ez.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
@SecondaryTable(name="customer_login_tbl")
@NamedQuery(name="getUsersByUnamePassword",query="FROM CustomerEntity cle WHERE cle.uname = :cleUserName and cle.password =:clePassword")
public class CustomerEntity {
	
	
	private String uname;
	
	private String password;
	
	private String role;
	
	@Column(table = "customer_login_tbl")
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(table = "customer_login_tbl")
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Column(table = "customer_login_tbl")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private int id;
	private String name;
	private String address;
	private String email;
	private Integer ssn;
	private String occupation;
	private String company;
	private String caddress;
	private String contact;
	private Double salary;
	private String gender;
	private String applicationStatus;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getApplicationStatus() {
		return applicationStatus;
		}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	public CustomerEntity(String uname, String password, int id, String name,
			String address, String email, Integer ssn, String occupation,
			String company, String caddress, String contact, Double salary,
			String gender) {
		super();
		this.uname = uname;
		this.password = password;
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.ssn = ssn;
		this.occupation = occupation;
		this.company = company;
		this.caddress = caddress;
		this.contact = contact;
		this.salary = salary;
		this.gender = gender;
	}
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
