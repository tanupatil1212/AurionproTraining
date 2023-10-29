package com.aurionpro.model;

import java.time.LocalDate;
import java.util.Date;

public class Student extends Person {
	private String branch;

	 public Student(int id, String address, LocalDate dOB, String branch) {
	  super(id, address, dOB);
	  this.branch = branch;
	 }

	 public String getBranch() {
	  return branch;
	 }

	 public void setBranch(String branch) {
	  this.branch = branch;
	 }

	 @Override
	 public String toString() {
	  return "Student [branch=" + branch + "]";
	 }

	

}
