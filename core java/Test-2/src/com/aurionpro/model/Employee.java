package com.aurionpro.model;

public abstract class Employee {
	private long employeeID;
	private String name;
	private double basic;



public Employee(long employeeID, String name, double basic) {
	super();
	this.employeeID = employeeID;
	this.name = name;
	this.basic = basic;
}

public Employee() {
	super();
}

public long getEmployeeID() {
	return employeeID;
}

public void setEmployeeID(long employeeID) {
	this.employeeID = employeeID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBasic() {
	return basic;
}

@Override
public String toString() {
	return "Employee [employeeID=" + employeeID + ", name=" + name + ", basic=" + basic + "]";
}

public void setBasic(double basic) {
	this.basic = basic;
}

public abstract double CalculateCTC(double salary);

}
