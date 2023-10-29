package com.aurionpro.test;

import com.aurionpro.model.Singleton;

public class SingletonTest1 {

	public static void main(String[] args) {
		Singleton obj1=Singleton.getSingletonInstance();
		obj1.printGrettings();
		
		Singleton obj2= Singleton.getSingletonInstance();
		obj2.printGrettings();

	}

}
