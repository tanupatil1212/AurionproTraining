package com.aurionpro.model;

public abstract class Employee {

	private Long employeeId;
	private String name;
	private double basic;

	public Employee(Long employeeId, String name, double basic) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.basic = basic;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	@Override
	public String toString() {
		return "Id=" + employeeId + ", \nname=" + name + ",\n basic=" + basic + "\n";
	}

	

	public double CalculateAnnualCTC() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double CalculateAnnualCTC(double salary) {
		// TODO Auto-generated method stub
		return salary;
	}

	

}
