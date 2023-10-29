package com.aurionpro.model;

public class Distance {
	
	private int inches;
	 @Override
	 public String toString() {
	  return "Distance [inches=" + inches + ", feet=" + feet + "]";
	 }

	 private int feet;
	 
	 public Distance(int inches, int feet) {
	  super();
	  this.inches = inches;
	  this.feet = feet;
	 }

	 public int getInches() {
	  return inches;
	 }

	 public void setInches(int inches) {
	  this.inches = inches;
	 }

	 public int getFeet() {
	  return feet;
	 }

	 public void setFeet(int feet) {
	  this.feet = feet;
	 } 
	 
	 
	 
	 
	 
	 
	}
	