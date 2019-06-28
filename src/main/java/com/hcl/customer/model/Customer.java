package com.hcl.customer.model;

import java.util.List;

public class Customer {

	private String custName;
	//@Column(updatable = false)
	private long accountNumber;
	private long custMobNum;
	private String custRole;
	private List<Address> address;
	


	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public long getAccountNumber() {
		return accountNumber;
		
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getCustMobNum() {
		return custMobNum;
	}

	public void setCustMobNum(long custMobNum) {
		this.custMobNum = custMobNum;
	}

	public String getCustRole() {
		return custRole;
	}

	public void setCustRole(String custRole) {
		this.custRole = custRole;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", accountNumber=" + accountNumber + ", custMobNum=" + custMobNum
				+ ", custRole=" + custRole + ", address=" + address + "]";
	}

	

}
