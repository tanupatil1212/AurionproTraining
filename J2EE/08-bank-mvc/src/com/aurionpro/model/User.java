package com.aurionpro.model;

public class User {
	
	private int user_id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	public User(int user_id, String fname, String lname, String username, String password) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	public User(String fname, String lname, String username, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", username=" + username
				+ ", password=" + password + "]";
	}

	
}
