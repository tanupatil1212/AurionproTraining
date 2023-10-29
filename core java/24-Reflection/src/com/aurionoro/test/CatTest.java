package com.aurionoro.test;

import java.lang.reflect.Field;

import com.aurionoro.model.Cat;

public class CatTest {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Cat myCat = new Cat("gorila",5);
		Field[] catFields = myCat.getClass().getDeclaredFields();
		
		for(Field field :catFields) {
			if(field.getName().equals("name")) {
				field.setAccessible(true);
				field.set(myCat, "tella");
			}
		}
			System.out.println(myCat.getName());
		
		
	}

}
