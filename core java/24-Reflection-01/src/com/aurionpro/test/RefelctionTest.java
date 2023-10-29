package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.aurionpro.model.SavingAccount;

public class RefelctionTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Class Name");
		String className=sc.nextLine();
		Class<?> tempClass = Class.forName(className);
		
		
		System.out.println("*********************Fields***********************");
		
		Field[] declaredFields = tempClass.getDeclaredFields();
		
		for(Field f:declaredFields) {
			System.out.println(f);
		}
		
		System.out.println("*********************Construcotr***********************");
		Constructor[] declaredConstructor = tempClass.getConstructors();
		for(Constructor c: declaredConstructor) {
			System.out.println(c);
		}
		System.out.println("*********************Methods***********************");
		Method[] methods = tempClass.getMethods();
		for(Method m:methods) {
			System.out.println(m);
		}
		
		Class<? super SavingAccount> superclass = SavingAccount.class.getSuperclass();
		System.out.println(superclass.getSimpleName());
 	}

}
