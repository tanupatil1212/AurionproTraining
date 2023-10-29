package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
	
	private RealInternet internet;
	private List<String> bannedSites;
	
	public  ProxyInternet() {
		super();
		internet= new RealInternet();
		bannedSites = new ArrayList<String>(Arrays.asList("Blocked Sites 1","Blocked Sites 2"));
	}
	@Override
	public void connectTo(String serverUrl) {
		if(bannedSites.contains(serverUrl)){
			System.out.println("Access to "+serverUrl+" is blocked");
			try {
				throw new InvalidAccessException("Access to "+serverUrl+ " is blocked");
			} catch (InvalidAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			internet.connectTo(serverUrl);
		}
		
	}
	   

}
