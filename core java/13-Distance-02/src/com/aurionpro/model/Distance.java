package com.aurionpro.model;

public class Distance {
	
	private int feet;
	 private int inch;
	 
	 public Distance(int feet, int inch) {
	  super();
	  this.feet = feet;
	  this.inch = inch;
	 }

	 public Distance() {
	  super();
	  // TODO Auto-generated constructor stub
	 }

	 public int getFeet() {
	  return feet;
	 }

	 public void setFeet(int feet) {
	  this.feet = feet;
	 }

	 public int getInch() {
	  return inch;
	 }

	 public void setInch(int inch) {
	  this.inch = inch;
	 }
	 
	 public Distance addDistance(Distance d) {
	  Distance temp = new Distance();
	  temp.setInch(this.getInch()+d.getInch());
	  temp.setFeet(this.getFeet()+d.getFeet());
	  return temp;
	 }

	 @Override
	 public String toString() {
	  return "Distance [feet=" + feet + ", inch=" + inch + "]";
	 }
	 
	 
	 
	}
	