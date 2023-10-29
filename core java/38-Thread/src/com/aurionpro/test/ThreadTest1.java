package com.aurionpro.test;

import com.aurionpro.model.PrintChar;

public class ThreadTest1 {
	public static void main(String[] args) {
	PrintChar printCharObj = new PrintChar();
	
	Thread t1 = new Thread(printCharObj);
	t1.start();
	
	Thread t2= new Thread(printCharObj);
	t2.start();
	

	
		

	}

}
