package com.aurionpro.model;

public class CustomerAsending {
	private int customerID;
	private String name;
	private String email;
	private int password;
	
	public CustomerAsending(int customerID, String name, String email, int password) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public CustomerAsending() {
		super();
	}



	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DisplayCustomerModel [customerID=" + customerID + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}

}
