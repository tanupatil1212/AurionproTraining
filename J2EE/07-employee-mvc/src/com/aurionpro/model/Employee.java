package com.aurionpro.model;

import java.util.Date;

public class Employee {

	private int id;
	private int emp_ID;
	private String first_name;
	private String last_name;
	private String email;
	private Date DOJ;
	private Date birthDate;
	private Date ELD;

	public Employee(int id, int emp_ID, String first_name, String last_name, String email, Date dOJ, Date birthDate,
			Date eLD) {
		super();
		this.id = id;
		this.emp_ID = emp_ID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		DOJ = dOJ;
		this.birthDate = birthDate;
		ELD = eLD;
	}

	public Employee(int emp_ID, String first_name, String last_name, String email, Date dOJ, Date birthDate, Date eLD) {
		super();
		this.emp_ID = emp_ID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		DOJ = dOJ;
		this.birthDate = birthDate;
		ELD = eLD;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(int emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getELD() {
		return ELD;
	}

	public void setELD(Date eLD) {
		ELD = eLD;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp_ID=" + emp_ID + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", DOJ=" + DOJ + ", birthDate=" + birthDate + ", ELD=" + ELD + "]";
	}

}
