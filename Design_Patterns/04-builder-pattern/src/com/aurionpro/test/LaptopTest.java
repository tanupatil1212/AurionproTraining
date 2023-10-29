package com.aurionpro.test;

import com.aurionpro.model.IGadget;

import com.aurionpro.model.LaptopBuilder;

public class LaptopTest {
	

	public static void main(String[] args) {
		LaptopBuilder builder = new LaptopBuilder();
		
		builder.addTouchScreen(true);
		builder.addId(101).addBrand("Dell");
		builder.addHdd("Segate 512GB").addRam("12GB").addProcessor("Intel core I7");
		
		IGadget laptop = builder.build();
		
		System.out.println(laptop.getBrand());
		System.out.println(laptop.getRam());
		

	}

}
