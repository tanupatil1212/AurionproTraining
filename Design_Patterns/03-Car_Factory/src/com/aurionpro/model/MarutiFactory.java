package com.aurionpro.model;

public class MarutiFactory implements ICarFactory {
	private static MarutiFactory marutiFactory;

	private MarutiFactory() {
	}

	public static MarutiFactory getMahindraFactoryInstance() {
		if (marutiFactory == null) {
			marutiFactory = new MarutiFactory();
		}
		return marutiFactory;
	}

	@Override
	public ICars makeCar() {
		return new Maruti();
	}
}
