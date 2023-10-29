package com.aurionpro.model;

public class FixedDeposit {
	private int accountNumber;
	private String name;
	private double principal;
	private int duration;
	private FestivalType festival;
	private IFestivalInterest festivalInterest;
	
	
	 public FixedDeposit(int accountNumber, String name, double principal, int duration, FestivalType festival,
			IFestivalInterest festivalInterest) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.principal = principal;
		this.duration = duration;
		this.festival = festival;
		this.festivalInterest = festivalInterest;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}

	public IFestivalInterest getFestivalInterest() {
		return festivalInterest;
	}

	public void setFestivalInterest(IFestivalInterest festivalInterest) {
		this.festivalInterest = festivalInterest;
	}

	public double getInterestRate() {
	        return festivalInterest.getInterestRate();
	    }
	
	public double calculateSimpleInterest() {
		double interestRate = getInterestRate();
        double interest = (principal * interestRate * duration) / 100;
        return interest;
		
	}

	@Override
	public String toString() {
		return "\nFixedDeposit [accountNumber=" + accountNumber + ", name=" + name + ", principal=" + principal
				+ ", duration=" + duration + ", festival=" + festival + ", festivalInterest=" + festivalInterest + "]";
	}
	
	

}
