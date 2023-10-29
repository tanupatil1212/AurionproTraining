package com.aurionpro.model;

public class StandardHat implements IHat {

	@Override
	public String getName() {

		return "PremiumHat";
	}

	@Override
	public double getPrice() {

		return 100;
	}

	@Override
	public String getDescription() {

		return "hatt in the Standard Hat";
	}

}
