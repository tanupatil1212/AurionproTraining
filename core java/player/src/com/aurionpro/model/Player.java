package com.aurionpro.model;

public class Player {
	private String name;
	private int age;
	private String country;
	private int Scored;
	private int fifties;
	private int hundreds;
	
	public Player(String name, int age, String country, int scored, int fifties, int hundreds) {
		super();
		this.name = name;
		this.age = age;
		this.country = country;
		Scored = scored;
		this.fifties = fifties;
		this.hundreds = hundreds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getScored() {
		return Scored;
	}

	public void setScored(int scored) {
		Scored = scored;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getHundreds() {
		return hundreds;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", country=" + country + ", Scored=" + Scored + ", fifties="
				+ fifties + ", hundreds=" + hundreds + "]";
	}

}

