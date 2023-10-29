package com.aurionpro.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {

	private int trans_id;
	private int account_no;
	private int transaction_type_id;
	private Timestamp transaction_time;
	private String description; // New field for transaction description
	private BigDecimal amount; // New field for transaction amount

	public Transaction(int trans_id, int account_no, int transaction_type_id, Timestamp transaction_time,
			String description, BigDecimal amount) {
		super();
		this.trans_id = trans_id;
		this.account_no = account_no;
		this.transaction_type_id = transaction_type_id;
		this.transaction_time = transaction_time;
		this.description = description;
		this.amount = amount;
	}

	public Transaction(int trans_id, int transaction_type_id, Timestamp transaction_time, String description,
			BigDecimal amount) {
		super();
		this.trans_id = trans_id;
		this.transaction_type_id = transaction_type_id;
		this.transaction_time = transaction_time;
		this.description = description;
		this.amount = amount;
	}

	public Transaction() {
		super();
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public int getTransaction_type_id() {
		return transaction_type_id;
	}

	public void setTransaction_type_id(int transaction_type_id) {
		this.transaction_type_id = transaction_type_id;
	}

	public Timestamp getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Timestamp transaction_time) {
		this.transaction_time = transaction_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", account_no=" + account_no + ", transaction_type_id="
				+ transaction_type_id + ", transaction_time=" + transaction_time + ", description=" + description
				+ ", amount=" + amount + "]";
	}

}
