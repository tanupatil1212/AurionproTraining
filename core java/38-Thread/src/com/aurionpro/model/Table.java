package com.aurionpro.model;

public class Table implements Runnable {
	
	private int number;
	
	public Table(int number) {
		this.number = number;
		
	}
	public int getNumber() {
		return number;
		
	}
	public void setNumber(int number) {
		this.number=number;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			System.out.println(number + " x "+ i + " = " + (number * i));
			
		}
		
	}
	

}
