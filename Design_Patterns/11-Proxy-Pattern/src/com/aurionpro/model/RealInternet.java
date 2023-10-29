package com.aurionpro.model;

public class RealInternet implements Internet{
	
	@Override
	public void connectTo(String server) {
		System.out.println("Connecting to "+server);
	}

}
