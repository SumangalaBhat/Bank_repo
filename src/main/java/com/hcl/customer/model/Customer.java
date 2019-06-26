package com.hcl.customer.model;

public class Customer {

	private String custName;
	private long accountNumber;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	private long custMobNum;
	private String custRole;

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
				+ ", custRole=" + custRole + "]";
	}

}
