package com.aurionpro.model;

public class InternetTest {

	public static void main(String[] args) {
Internet internet = new ProxyInternet();
		
		internet.connectTo("www.google.com");
		internet.connectTo("blockedSite1.com");

	}

}
