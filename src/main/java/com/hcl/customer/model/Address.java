package com.hcl.customer.model;

public class Address {
	
	
	private String city;
	private String State;
	private int pincode;
	private String typeOfAddress;
	
	public String getTypeOfAddress() {
		return typeOfAddress;
	}
	public void setTypeOfAddress(String typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", State=" + State + ", pincode=" + pincode + ", typeOfAddress="
				+ typeOfAddress + "]";
	}


}
