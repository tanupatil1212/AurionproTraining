package com.aurionpro.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public abstract class Person {
	protected int id;
	 protected String address;
	 protected LocalDate DOB;
	 
	 public Person(int id, String address, LocalDate dOB) {
	  super();
	  this.id = id;
	  this.address = address;
	  this.DOB = dOB;
	 }

	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }
	 public String getAddress() {
	  return address;
	 }
	 public void setAddress(String address) {
	  this.address = address;
	 }
	 public LocalDate getDOB() {
	  return DOB;
	 }
	 public void setDOB(LocalDate dOB) {
	  this.DOB = dOB;
	 }
	 
	 public String formatDate(LocalDate date) {
	  return date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
	 }
	 @Override
	 public String toString() {
	  return "Person [id=" + id + ", address=" + address + ", DOB=" + DOB + ",branch=\" + branch + \"]";
	 }
	 
	 
	 
}
