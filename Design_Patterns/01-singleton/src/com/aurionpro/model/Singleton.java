package com.aurionpro.model;

public class Singleton {
	
	private static Singleton singleton;
	private Singleton() {
		
	}
	
	public static Singleton getSingletonInstance() {
		if(singleton==null) {
			singleton=new Singleton();
		}
		return singleton;
	}
   public void printGrettings() {
	   System.out.println(this.hashCode()+":Welcome");
   }
	
}
