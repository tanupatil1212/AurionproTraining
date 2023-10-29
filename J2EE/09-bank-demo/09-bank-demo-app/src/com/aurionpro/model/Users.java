package com.aurionpro.model;

import java.util.List;

public class Users {
	private int userId;
    private List<Account> accounts;
	public Users(int userId, List<Account> accounts) {
		super();
		this.userId = userId;
		this.accounts = accounts;
	}
	public Users(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}
	public Users() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", accounts=" + accounts + "]";
	}
    
    

}
