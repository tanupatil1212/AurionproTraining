package com.aurionpro.model;

import java.math.BigDecimal;

public class Account {

	private int accountno;
	private String accounttype;
	private int userid;
	private BigDecimal amount;
	

	public Account(int accountno, String accounttype, int userid, BigDecimal amount) {
		super();
		this.accountno = accountno;
		this.accounttype = accounttype;
		this.userid = userid;
		this.amount = amount;
	}

	public Account(int accountno, String accounttype, BigDecimal amount) {
		super();
		this.accountno = accountno;
		this.accounttype = accounttype;
		this.amount = amount;
	}

	public Account() {
		super();
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", accounttype=" + accounttype + ", userid=" + userid + ", amount="
				+ amount + "]";
	}

}