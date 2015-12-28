package com.ez.model;

public class Bank {

	private int bankId;
	private String name;
	private String address;
	private String branch;
	private String contact;


	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Bank(int bankId, String name, String address, String branch,
			String contact) {
		super();
		this.bankId = bankId;
		this.name = name;
		this.address = address;
		this.branch = branch;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", name=" + name + ", address="
				+ address + ", branch=" + branch + ", contact=" + contact + "]";
	}



	
}
