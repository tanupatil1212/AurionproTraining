package com.aurionpro.entity;

import java.util.Date;

public class Instructor {
	private int id;
	private String name;
	private String email;
	private Date dateOfJoining;

	public Instructor(int id, String name, String email, Date dateOfJoining) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}

}
