package com.aurionpro.model;

public interface IRepositary {
	int categories=10;
	void create();
	public abstract void read();
	void update();
	void delete();
	public default void showGrettings() {
		System.out.println("Hello");
	}
	public static void printWelcomeMessage() {
		System.out.println("hello wel to auro");
	}
	}
//static void printWelcomeMessage(): A static method that provides an implementation to print a welcome message. Static methods in interfaces are called using the interface name itself, and they can't be overridden.

//default void showGreetings(): A default method that provides a default implementation to display a greeting message. Default methods can have implementations and are used to provide a default behavior for methods that might be added to an existing interface.